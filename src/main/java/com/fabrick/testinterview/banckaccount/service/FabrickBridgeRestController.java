package com.fabrick.testinterview.banckaccount.service;

import java.io.IOException;
import java.math.BigDecimal;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.fabrick.testinterview.banckaccount.data.TransactionLocalPersistService;
import com.fabrick.testinterview.banckaccount.domain.dto.*;
import com.fabrick.testinterview.banckaccount.domain.entity.TransactionEntity;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.web.bind.annotation.*;

@RestController
public class FabrickBridgeRestController {


	private static final String BALANCE_ENDPOINT = "/api/gbs/banking/v4.0/accounts/{accountId}/balance";
	private static final String OPERATION_ENDPOINT = "/api/gbs/banking/v4.0/accounts/{accountId}/transactions?fromAccountingDate={*}&toAccountingDate={**}";
	private static final String MONEY_TRANSFER_OPERATION_ENDPOINT = "/api/gbs/banking/v4.0/accounts/{accountId}/payments/money-transfers";

	private final ObjectMapper objectMapper = new ObjectMapper();
	private final FabrickApiRestTemplateFactory fabrickApiRestTemplateFactory;
	private TransactionLocalPersistService transactionLocalPersistService;

	private FabrickBridgeRestController(
			FabrickApiRestTemplateFactory fabrickApiRestTemplateFactory, TransactionLocalPersistService transactionLocalPersistService ) {
		// TODO Auto-generated constructor stub
		this.fabrickApiRestTemplateFactory = fabrickApiRestTemplateFactory;
		this.transactionLocalPersistService = transactionLocalPersistService;

	}

	@Value("${fabrick.sandbox.base.url}")
	private String baseUrl;

	@Value("${fabrick.sandbox.account.id}")
	private Long accountId;
	
	@Value("${fabrick.sandbox.fromAccountingDate}")
	private String fromAccountingDate;
	
	@Value("${fabrick.sandbox.toAccountingDate}")
	private String toAccountingDate;

	@Value("${fabrick.sandbox.api.key}")
	private String apiKey;

	@Value("${fabrick.sandbox.auth.schema}")
	private String authSchema;

	@GetMapping(path = "/balance")
	public ResponseEntity<AccountRootResponseDto> getAccountBalance() throws URISyntaxException, IOException {
		ResponseEntity<String> response = fabrickApiRestTemplateFactory.get(baseUrl + replaceAccountData(BALANCE_ENDPOINT));
		AccountRootResponseDto accountRootResponseDto = objectMapper.readValue(response.getBody(), AccountRootResponseDto.class);
		 return ResponseEntity.ok(accountRootResponseDto);
	}

	@GetMapping(path = "/transactions")
	public RootResponseTransaction getAccountTransacions() throws URISyntaxException, IOException {
		ResponseEntity<String> response = fabrickApiRestTemplateFactory.get(baseUrl + replaceOperationData(OPERATION_ENDPOINT));
		RootResponseTransaction responseMapper =  objectMapper.readValue(response.getBody(), RootResponseTransaction.class);
		List<TransactionDto> transactionDto = responseMapper.getPayload().getList();
		transactionLocalPersistService.convertAndSaveTransaction(transactionDto);
		return responseMapper;
	}

	@GetMapping(path = "/localtransactions")
	public ResponseEntity<List<TransactionEntity>> getLocalTransacions() throws URISyntaxException, IOException {
		return ResponseEntity.ok(transactionLocalPersistService.getTransactionByLocalDb());

	}


	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping(path = "/moneytransfer", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> moneyTransferOperation(@RequestBody(required = true) MoneyTransferBodyDto requestDto) throws URISyntaxException, JsonProcessingException {
		ResponseEntity<String> response = fabrickApiRestTemplateFactory.post(baseUrl + replaceAccountData(MONEY_TRANSFER_OPERATION_ENDPOINT), DtoToJsonStinrgBodyData(requestDto));
		if (response.getStatusCode().equals("KO")) {
            RootErrorResponseMoneyTransfer responseMoneyTransfer = ((RootErrorResponseMoneyTransfer) objectMapper.readValue(response.getBody(), RootErrorResponseMoneyTransfer.class));
            response = ResponseEntity.ok("CODICE ERRORE : " +responseMoneyTransfer.getErrors().get(0).getCode() + " Descrizione : " +  responseMoneyTransfer.getErrors().get(0).getDescription());
        }
		return  response;
	}

	private String replaceAccountData(String data){
		return StringUtils.replace(data, "{accountId}", accountId.toString());
	}
	
	private String replaceOperationData(String data){
		data = StringUtils.replace(data, "{accountId}", accountId.toString());
		data = StringUtils.replace(data, "{*}", fromAccountingDate);
		data = StringUtils.replace(data, "{**}", toAccountingDate);
		return  data;
	}
		
	private String DtoToJsonStinrgBodyData(Object requestObject) {

		try {
			String json = objectMapper.writeValueAsString(requestObject);
			return json;
		} catch (JsonProcessingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return "";
	}

}
