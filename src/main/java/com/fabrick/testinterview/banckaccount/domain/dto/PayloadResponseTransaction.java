package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class PayloadResponseTransaction {

        @JsonProperty("list")
        public List<TransactionDto> getList() {
            return this.list; }
        public void setList(List<TransactionDto> list) {
            this.list = list; }
        List<TransactionDto> list;

}
