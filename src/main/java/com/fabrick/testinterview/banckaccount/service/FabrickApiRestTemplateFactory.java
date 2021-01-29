package com.fabrick.testinterview.banckaccount.service;

import java.net.URISyntaxException;

import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;

public interface FabrickApiRestTemplateFactory {

	ResponseEntity<String> get(String path) throws URISyntaxException;

    ResponseEntity<String>  post(String path, Object body) throws URISyntaxException, JsonProcessingException;
	
}
