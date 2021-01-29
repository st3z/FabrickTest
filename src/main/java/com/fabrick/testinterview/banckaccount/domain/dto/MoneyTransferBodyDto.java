package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MoneyTransferBodyDto {

    @JsonProperty("creditor")
    public Creditor getCreditor() {
        return this.creditor; }
    public void setCreditor(Creditor creditor) {
        this.creditor = creditor; }
    Creditor creditor;
    @JsonProperty("executionDate")
    public String getExecutionDate() {
        return this.executionDate; }
    public void setExecutionDate(String executionDate) {
        this.executionDate = executionDate; }
    String executionDate;
    @JsonProperty("uri")
    public String getUri() {
        return this.uri; }
    public void setUri(String uri) {
        this.uri = uri; }
    String uri;
    @JsonProperty("description")
    public String getDescription() {
        return this.description; }
    public void setDescription(String description) {
        this.description = description; }
    String description;
    @JsonProperty("amount")
    public int getAmount() {
        return this.amount; }
    public void setAmount(int amount) {
        this.amount = amount; }
    int amount;
    @JsonProperty("currency")
    public String getCurrency() {
        return this.currency; }
    public void setCurrency(String currency) {
        this.currency = currency; }
    String currency;
    @JsonProperty("isUrgent")
    public boolean getIsUrgent() {
        return this.isUrgent; }
    public void setIsUrgent(boolean isUrgent) {
        this.isUrgent = isUrgent; }
    boolean isUrgent;
    @JsonProperty("isInstant")
    public boolean getIsInstant() {
        return this.isInstant; }
    public void setIsInstant(boolean isInstant) {
        this.isInstant = isInstant; }
    boolean isInstant;
    @JsonProperty("feeType")
    public String getFeeType() {
        return this.feeType; }
    public void setFeeType(String feeType) {
        this.feeType = feeType; }
    String feeType;
    @JsonProperty("feeAccountId")
    public String getFeeAccountId() {
        return this.feeAccountId; }
    public void setFeeAccountId(String feeAccountId) {
        this.feeAccountId = feeAccountId; }
    String feeAccountId;
    @JsonProperty("taxRelief")
    public TaxRelief getTaxRelief() {
        return this.taxRelief; }
    public void setTaxRelief(TaxRelief taxRelief) {
        this.taxRelief = taxRelief; }
    TaxRelief taxRelief;
}
