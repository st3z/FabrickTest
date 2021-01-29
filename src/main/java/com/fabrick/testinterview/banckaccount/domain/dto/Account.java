package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Account {

    @JsonProperty("accountCode")
    public String getAccountCode() {
        return this.accountCode; }
    public void setAccountCode(String accountCode) {
        this.accountCode = accountCode; }
    String accountCode;
    @JsonProperty("bicCode")
    public String getBicCode() {
        return this.bicCode; }
    public void setBicCode(String bicCode) {
        this.bicCode = bicCode; }
    String bicCode;
}
