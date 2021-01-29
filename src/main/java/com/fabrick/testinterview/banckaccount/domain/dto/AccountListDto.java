package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountListDto {

	String accountId;
	String iban;
	String abiCode;
	String cabCode;
	String countryCode;
	String internationalCin;
	String nationalCin;	
	String account;
	String alias;
	String productName;
	String holderName;
	String activatedDate;
	String currency;

	
	@JsonProperty("accountId") 
	public String getAccountId() { 
		return this.accountId; } 
	public void setAccountId(String accountId) { 
		this.accountId = accountId; } 
	
	@JsonProperty("iban") 
	public String getIban() { 
		return this.iban; } 
	public void setIban(String iban) { 
		this.iban = iban; } 
	
	@JsonProperty("abiCode") 
	public String getAbiCode() { 
		return this.abiCode; } 
	public void setAbiCode(String abiCode) { 
		this.abiCode = abiCode; } 
	
	@JsonProperty("cabCode") 
	public String getCabCode() { 
		return this.cabCode; } 
	public void setCabCode(String cabCode) { 
		this.cabCode = cabCode; } 

	@JsonProperty("countryCode") 
	public String getCountryCode() { 
		return this.countryCode; } 
	public void setCountryCode(String countryCode) { 
		this.countryCode = countryCode; } 
	
	@JsonProperty("internationalCin") 
	public String getInternationalCin() { 
		return this.internationalCin; } 
	public void setInternationalCin(String internationalCin) { 
		this.internationalCin = internationalCin; } 

	@JsonProperty("nationalCin") 
	public String getNationalCin() { 
		return this.nationalCin; } 
	public void setNationalCin(String nationalCin) { 
		this.nationalCin = nationalCin; } 
	
	@JsonProperty("account") 
	public String getAccount() { 
		return this.account; } 
	public void setAccount(String account) { 
		this.account = account; } 

	@JsonProperty("alias") 
	public String getAlias() { 
		return this.alias; } 
	public void setAlias(String alias) { 
		this.alias = alias; } 
	
	@JsonProperty("productName") 
	public String getProductName() { 
		return this.productName; } 
	public void setProductName(String productName) { 
		this.productName = productName; } 
	
	@JsonProperty("holderName") 
	public String getHolderName() { 
		return this.holderName; } 
	public void setHolderName(String holderName) { 
		this.holderName = holderName; } 
	
	@JsonProperty("activatedDate") 
	public String getActivatedDate() { 
		return this.activatedDate; } 
	public void setActivatedDate(String activatedDate) { 
		this.activatedDate = activatedDate; } 
	
	@JsonProperty("currency") 
	public String getCurrency() { 
		return this.currency; } 
	public void setCurrency(String currency) { 
		this.currency = currency; } 

}
