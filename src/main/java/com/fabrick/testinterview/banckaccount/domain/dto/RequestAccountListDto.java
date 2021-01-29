package com.fabrick.testinterview.banckaccount.domain.dto;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RequestAccountListDto {

	List<AccountListDto> list;
	
	@JsonProperty("list") 
	public List<AccountListDto> getList() { 
		return this.list; } 
	public void setList(List<AccountListDto> list) { 
		this.list = list; } 
	
}
