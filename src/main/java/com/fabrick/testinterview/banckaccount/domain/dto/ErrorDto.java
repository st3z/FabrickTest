package com.fabrick.testinterview.banckaccount.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class ErrorDto {


	String code;
	String description;
	List<Object> params;

	@JsonProperty("code") 
	public String getCode() { 
		return this.code; } 
	public void setCode(String code) { 
		this.code = code; } 

	@JsonProperty("description") 
	public String getDescription() { 
		return this.description; } 
	public void setDescription(String description) { 
		this.description = description; } 

	@JsonProperty("params") 
	public List<Object> getParams() { 
		return this.params; } 
	public void setParams(List<Object> params) { 
		this.params = params; } 


}
