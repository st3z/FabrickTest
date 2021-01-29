package com.fabrick.testinterview.banckaccount.service;

import com.fabrick.testinterview.banckaccount.data.TransactionLocalPersistService;
import com.fabrick.testinterview.banckaccount.domain.dto.TransactionDto;
import com.fabrick.testinterview.banckaccount.domain.dto.TypeDto;
import com.fabrick.testinterview.banckaccount.domain.entity.TransactionEntity;
import com.fabrick.testinterview.banckaccount.domain.entity.TransactionRepository;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TransactionLocalPersistServiceTest {

    @Autowired
    TransactionLocalPersistService transactionLocalPersistService;


    @Test
    public void transactionDbTest() {

        List<TransactionDto> transactionDtoList = new ArrayList<TransactionDto>();

        TransactionDto transactionDto = new TransactionDto();
        TypeDto typeDto = new TypeDto();
        typeDto.setEnumeration("1");
        transactionDto.setTransactionId("1");
        transactionDto.setType(typeDto);
        transactionDto.setDescription("Descrizione TRANSAZIONE 1");
        TransactionDto transactionDtoTwo = new TransactionDto();
        transactionDtoTwo.setType(typeDto);
        transactionDtoTwo.setTransactionId("2");
        transactionDtoTwo.setDescription("Descrizione TRANSAZIONE 2");
        transactionDtoList.add(transactionDto);
        transactionDtoList.add(transactionDtoTwo);

        Assert.assertEquals(Integer.parseInt( "2"), transactionLocalPersistService.convertAndSaveTransaction(transactionDtoList).size());

        TransactionDto transactionDtoThree = new TransactionDto();
        transactionDtoThree.setType(typeDto);
        transactionDtoThree.setTransactionId("2");
        transactionDtoThree.setDescription("Descrizione TRANSAZIONE 2");
        TransactionDto transactionDtoFour = new TransactionDto();
        transactionDtoFour.setType(typeDto);
        transactionDtoFour.setTransactionId("4");
        transactionDtoFour.setDescription("Descrizione TRANSAZIONE 2");
        transactionDtoList.add(transactionDtoThree);
        transactionDtoList.add(transactionDtoFour);
        transactionLocalPersistService.convertAndSaveTransaction(transactionDtoList).size();
        Assert.assertEquals(Integer.parseInt( "3"), transactionLocalPersistService.getAll().size());


    }

}
