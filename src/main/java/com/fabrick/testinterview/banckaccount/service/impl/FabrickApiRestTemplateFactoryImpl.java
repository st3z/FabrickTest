package com.fabrick.testinterview.banckaccount.service.impl;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.Set;

import com.fabrick.testinterview.banckaccount.domain.dto.RootErrorResponseMoneyTransfer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import com.fabrick.testinterview.banckaccount.common.exception.FabrickException;
import com.fabrick.testinterview.banckaccount.domain.dto.ErrorDto;
import com.fabrick.testinterview.banckaccount.service.FabrickApiRestTemplateFactory;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;


@Service
public class FabrickApiRestTemplateFactoryImpl implements FabrickApiRestTemplateFactory {

	private ObjectMapper objectMapper = new ObjectMapper();
	
	private RestTemplate restTemplate;
	
	@Value("${fabrick.sandbox.api.key}")
	private String apiKey;

	@Value("${fabrick.sandbox.auth.schema}")
	private String authSchema;


	public FabrickApiRestTemplateFactoryImpl(RestTemplateBuilder builder) {
		this.restTemplate = builder.build();
	}
	
	
	@Override
	public ResponseEntity<String> get(String endpoint) throws URISyntaxException {
		HttpEntity<Object> requestEntity = new HttpEntity<>(null, fabrickSandboxHeaders());
		ResponseEntity<String> response = restTemplate.exchange(new URI(endpoint), HttpMethod.GET, requestEntity, String.class);
		checkResponse(response);
		return response;
	}



	private HttpHeaders fabrickSandboxHeaders() {
		HttpHeaders headers = new HttpHeaders();
		headers.set("Content-Type", MediaType.APPLICATION_JSON_VALUE);
		headers.set("Auth-Schema", authSchema);
		headers.set("Api-Key", apiKey);
		return headers;
	}


	@Override
	public ResponseEntity<String> post(String endpoint, Object body) throws URISyntaxException, JsonProcessingException {
		HttpEntity<Object> request = new HttpEntity<>(body, fabrickSandboxHeaders());
		ResponseEntity<String> response = null;
		try {
			response = restTemplate.exchange(new URI(endpoint), HttpMethod.POST, request, String.class);
			checkResponse(response);
		} catch (HttpClientErrorException e) {
			if (!isAnError(e.getResponseBodyAsString())) {
				throw e;
			}
            else {
                response = ResponseEntity.ok(e.getResponseBodyAsString());
				return response;
			}
		}
		return response;
	}

	private void checkResponse(ResponseEntity<String> response) {
			if (!response.getStatusCode().equals(HttpStatus.OK)) {
				String body = response.getBody();
				String errorMessage = "";
				try {
					errorMessage = 	((ErrorDto) objectMapper.readValue(body, ErrorDto.class)).toString();
				} catch (Exception ex) { }
			throw new FabrickException(errorMessage);
		}
	}

	private boolean isAnError(String body) throws JsonProcessingException {
		RootErrorResponseMoneyTransfer response = ((RootErrorResponseMoneyTransfer) objectMapper.readValue(body, RootErrorResponseMoneyTransfer.class));
		if (response != null && response.getErrors() != null)
			if (response.getErrors() != null && response.getErrors().size() > 0 ) {
				if (response.getErrors().get(0).getCode().equals("API000")) {
					return true;
				}
			}
		return false;
	}
}
