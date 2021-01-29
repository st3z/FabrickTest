package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class AccountRootResponseDto {

    String status;
    List<ErrorDto> error;
    BalanceResponseDto balanceResponseDto;

    @JsonProperty("status")
    public String getStatus() {
        return this.status; }
    public void setStatus(String status) {
        this.status = status; }

    @JsonProperty("error")
    public List<ErrorDto> getError() {
        return this.error; }
    public void setError(List<ErrorDto> error) {
        this.error = error; }

    @JsonProperty("payload")
    public BalanceResponseDto getPayload() {
        return this.balanceResponseDto; }
    public void setPayload(BalanceResponseDto balanceResponseDto) {
        this.balanceResponseDto = balanceResponseDto; }

}
