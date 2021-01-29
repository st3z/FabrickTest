package com.fabrick.testinterview.banckaccount.data;

import com.fabrick.testinterview.banckaccount.domain.dto.TransactionDto;
import com.fabrick.testinterview.banckaccount.domain.entity.TransactionEntity;
import com.fabrick.testinterview.banckaccount.domain.entity.TransactionRepository;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TransactionLocalPersistService {

    TransactionRepository transactionRepository;

    public TransactionLocalPersistService(TransactionRepository transactionRepository) {
         this.transactionRepository = transactionRepository;
    }

    public List<TransactionEntity>  convertAndSaveTransaction(List<TransactionDto> transactionDtoList) {
        List<TransactionEntity> transactionEntityList = new ArrayList<TransactionEntity>();
        for (TransactionDto transactionDto : transactionDtoList) {
            TransactionEntity transactionEntity = new TransactionEntity();
            transactionEntity.setAccountingDate(transactionDto.getAccountingDate());
            transactionEntity.setAmount(transactionDto.getAmount());
            transactionEntity.setCurrency(transactionDto.getCurrency());
            transactionEntity.setTypeEnumeration(transactionDto.getType().getEnumeration());
            transactionEntity.setOperationId(transactionDto.getOperationId());
            transactionEntity.setTransactionId(transactionDto.getTransactionId());
            transactionEntity.setTypeValue(transactionDto.getType().getValue());
            transactionEntity.setDescription(transactionDto.getDescription());
            transactionEntity.setValueDate(transactionDto.getValueDate());
            transactionEntityList.add(transactionEntity);
        }


        List<TransactionEntity> transactionEntities = getAll();
        List<TransactionEntity> diff  = transactionEntityList.stream().filter(o1 -> transactionEntities.stream().noneMatch(o2 -> o2.getTransactionId().equals(o1.getTransactionId())))
                .collect(Collectors.toList());
       List<TransactionEntity> transactionEntities1 = transactionRepository.saveAll(diff);
       return transactionEntities1;
    }

    public List<TransactionEntity>  getTransactionByLocalDb() {
        List<TransactionEntity> transactionEntities = getAll();
        return transactionEntities;
    }

    public List<TransactionEntity> getAll() {
        return transactionRepository.findAll();
    }
}
