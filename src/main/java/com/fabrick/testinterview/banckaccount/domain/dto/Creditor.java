package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Creditor {

    @JsonProperty("name")
    public String getName() {
        return this.name; }
    public void setName(String name) {
        this.name = name; }
    String name;
    @JsonProperty("account")
    public Account getAccount() {
        return this.account; }
    public void setAccount(Account account) {
        this.account = account; }
    Account account;
    @JsonProperty("address")
    public Address getAddress() {
        return this.address; }
    public void setAddress(Address address) {
        this.address = address; }
    Address address;
}
