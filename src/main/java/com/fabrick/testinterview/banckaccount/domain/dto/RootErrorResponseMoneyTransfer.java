package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class RootErrorResponseMoneyTransfer {
    @JsonProperty("status")
    public String getStatus() {
        return this.status; }
    public void setStatus(String status) {
        this.status = status; }
    String status;
    @JsonProperty("errors")
    public List<ErrorResponseMoneyTransfer> getErrors() {
        return this.errors; }
    public void setErrors(List<ErrorResponseMoneyTransfer> errors) {
        this.errors = errors; }
    List<ErrorResponseMoneyTransfer> errors;
    @JsonProperty("payload")
    public Payload getPayload() {
        return this.payload; }
    public void setPayload(Payload payload) {
        this.payload = payload; }
    Payload payload;
}
