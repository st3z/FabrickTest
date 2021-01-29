package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RootResponseTransaction {

    @JsonProperty("status")
    public String getStatus() {
        return this.status; }
    public void setStatus(String status) {
        this.status = status; }
    String status;
    @JsonProperty("error")
    public List<ErrorDto> getError() {
        return this.error; }
    public void setError(List<ErrorDto> error) {
        this.error = error; }
    List<ErrorDto> error;
    @JsonProperty("payload")
    public PayloadResponseTransaction getPayload() {
        return this.payload; }
    public void setPayload(PayloadResponseTransaction payload) {
        this.payload = payload; }
    PayloadResponseTransaction payload;
}