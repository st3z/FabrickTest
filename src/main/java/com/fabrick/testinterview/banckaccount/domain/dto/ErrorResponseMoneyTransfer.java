package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorResponseMoneyTransfer {
    @JsonProperty("code")
    public String getCode() {
        return this.code; }
    public void setCode(String code) {
        this.code = code; }
    String code;
    @JsonProperty("description")
    public String getDescription() {
        return this.description; }
    public void setDescription(String description) {
        this.description = description; }
    String description;
    @JsonProperty("params")
    public String getParams() {
        return this.params; }
    public void setParams(String params) {
        this.params = params; }
    String params;
}
