package com.fabrick.testinterview.banckaccount.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class AccountRootDto {

	String status;
	List<ErrorDto> errors;
	AccountPayloadDto payload;
	
	@JsonProperty("status") 
	public String getStatus() { 
		return this.status; } 
	public void setStatus(String status) { 
		this.status = status; } 
	
    @JsonProperty("errors") 
    public List<ErrorDto> getErrors() { 
		 return this.errors; } 
    public void setErrors(List<ErrorDto> errors) { 
		 this.errors = errors; } 
    

	@JsonProperty("payload") 
	public AccountPayloadDto getPayload() { 
		return this.payload; } 

	public void setPayload(AccountPayloadDto payload) { 
		this.payload = payload; } 
	
}
