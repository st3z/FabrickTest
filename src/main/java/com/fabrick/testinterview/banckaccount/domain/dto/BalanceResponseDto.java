package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class BalanceResponseDto {

	String date;
	double balance;
	double availableBalance;
	String currency;

	@JsonProperty("date") 
	public String getDate() { 
		return this.date; } 
	public void setDate(String date) { 
		this.date = date; } 

	@JsonProperty("balance") 
	public double getBalance() { 
		return this.balance; } 
	public void setBalance(double balance) { 
		this.balance = balance; } 

	@JsonProperty("availableBalance") 
	public double getAvailableBalance() { 
		return this.availableBalance; } 
	public void setAvailableBalance(double availableBalance) { 
		this.availableBalance = availableBalance; } 

	@JsonProperty("currency") 
	public String getCurrency() { 
		return this.currency; } 
	public void setCurrency(String currency) { 
		this.currency = currency; } 



}
