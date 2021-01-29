package com.fabrick.testinterview.banckaccount.service;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import com.fabrick.testinterview.banckaccount.data.TransactionLocalPersistService;
import com.fabrick.testinterview.banckaccount.domain.dto.*;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.ResponseEntity;

import org.springframework.test.util.ReflectionTestUtils;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

@RunWith(MockitoJUnitRunner.class)
public class AccountControllerTest {
	

    @InjectMocks
    private FabrickBridgeRestController fabrickBridgeRestController;

    @Mock
    private FabrickApiRestTemplateFactory fabrickApiRestTemplateFactory;

    @Mock
    private TransactionLocalPersistService transactionLocalPersistService;

    @Before
    public void setup() {
        ReflectionTestUtils.setField(fabrickBridgeRestController, "accountId", 14537780L);
        ReflectionTestUtils.setField(fabrickBridgeRestController, "authSchema", "S2S");
        ReflectionTestUtils.setField(fabrickBridgeRestController, "apiKey", "FXOVVXXHVCPVPBZXIJOBGUGSKHDNFRRQJP");
        ReflectionTestUtils.setField(fabrickBridgeRestController, "baseUrl", "https://sandbox.platfr.io");
        ReflectionTestUtils.setField(fabrickBridgeRestController, "fromAccountingDate", "01-01-2019");
        ReflectionTestUtils.setField(fabrickBridgeRestController, "toAccountingDate", "31-12-2019");
    }
    
    @Test
    public void callAccountBalanceTest() throws IOException, URISyntaxException {
        doReturn(mockBalanceResponseEntity()).when(fabrickApiRestTemplateFactory).get(any(String.class));
		ResponseEntity<AccountRootResponseDto> accountRootResponseDto = fabrickBridgeRestController.getAccountBalance();
		if (accountRootResponseDto.getBody().getStatus() != null && accountRootResponseDto.getBody().getStatus().equals("OK") ) {
		    double assertion = 10.89;
            Assert.assertEquals(Double.parseDouble("10.89"), accountRootResponseDto.getBody().getPayload().getBalance(),0);
		}
    }

    @Test
    public void callMoneyTransferOperationTest() throws URISyntaxException, JsonProcessingException {
        doReturn(mockMoneyTransferResponseEntity()).when(fabrickApiRestTemplateFactory).post(any(String.class),any(String.class));
        ResponseEntity<String> response = fabrickBridgeRestController.moneyTransferOperation(createMoneyTransferBody());
        Assert.assertEquals("API0000 + ERROR SERVICE" , response.getBody());

    }

    private ResponseEntity<String> mockMoneyTransferResponseEntity() {
        ResponseEntity<String> rootErrorResponseMoneyTransfer = ResponseEntity.ok("API0000 + ERROR SERVICE");
        return rootErrorResponseMoneyTransfer;
    }


    @Test
    public  void callTransactionTest() throws IOException, URISyntaxException {
        doReturn(mockTransactionResponseEntity()).when(fabrickApiRestTemplateFactory).get(any(String.class));
        RootResponseTransaction responseTransaction =  fabrickBridgeRestController.getAccountTransacions();
        Assert.assertEquals("2021-01-29",responseTransaction.getPayload().getList().get(0).getAccountingDate());
        Assert.assertEquals("EUR",responseTransaction.getPayload().getList().get(0).getCurrency());
        Assert.assertEquals("NOT PROVIDED",responseTransaction.getPayload().getList().get(0).getDescription());
        Assert.assertEquals("20000178206975",responseTransaction.getPayload().getList().get(0).getOperationId());
        Assert.assertEquals("1627525111001",responseTransaction.getPayload().getList().get(0).getTransactionId());


    }

    private ResponseEntity<String> mockTransactionResponseEntity() throws JsonProcessingException {
        RootResponseTransaction mock = getTransactionRootResponseDto();
        ResponseEntity<String> response = ResponseEntity.ok(new ObjectMapper().writeValueAsString(mock));
        return response;
    }

    private RootResponseTransaction getTransactionRootResponseDto() {
        RootResponseTransaction rootResponseTransaction = new RootResponseTransaction();
        List<ErrorDto> errorDtoList = new ArrayList<ErrorDto>();
        rootResponseTransaction.setError(errorDtoList);
        rootResponseTransaction.setStatus("OK");
        PayloadResponseTransaction payloadResponseTransaction = new PayloadResponseTransaction();
        List<TransactionDto> transactionDtos = new ArrayList<TransactionDto>();
        TransactionDto transactionDto = new TransactionDto();
        transactionDto.setAccountingDate("2021-01-29");
        transactionDto.setAmount(10);
        transactionDto.setCurrency("EUR");
        transactionDto.setDescription("NOT PROVIDED");
        transactionDto.setOperationId("20000178206975");
        transactionDto.setTransactionId("1627525111001");
        transactionDtos.add(transactionDto);
        payloadResponseTransaction.setList(transactionDtos);
        rootResponseTransaction.setPayload(payloadResponseTransaction);
        return  rootResponseTransaction;
    }

    private MoneyTransferBodyDto createMoneyTransferBody() {
        MoneyTransferBodyDto moneyTransferBodyDto = new MoneyTransferBodyDto();

        return  moneyTransferBodyDto;
    }


    private ResponseEntity<String> mockBalanceResponseEntity() throws JsonProcessingException {
        AccountRootResponseDto mock = getBalanceRootResponseDto();
        ResponseEntity<String> response = ResponseEntity.ok(new ObjectMapper().writeValueAsString(mock));
        return response ;
    }

    private AccountRootResponseDto getBalanceRootResponseDto() {
        AccountRootResponseDto accountRootResponseDto = new AccountRootResponseDto();
        List<ErrorDto> errorDtoList = new ArrayList<ErrorDto>();
        accountRootResponseDto.setStatus("OK");
        BalanceResponseDto balanceResponseDto = new BalanceResponseDto();
        balanceResponseDto.setBalance(10.89);
        accountRootResponseDto.setPayload(balanceResponseDto);
        accountRootResponseDto.setError(errorDtoList);
        return accountRootResponseDto;
    }

}
