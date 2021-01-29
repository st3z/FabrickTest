package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Address {
    @JsonProperty("address")
    public Object getAddress() {
        return this.address; }
    public void setAddress(Object address) {
        this.address = address; }
    Object address;
    @JsonProperty("city")
    public Object getCity() {
        return this.city; }
    public void setCity(Object city) {
        this.city = city; }
    Object city;
    @JsonProperty("countryCode")
    public Object getCountryCode() {
        return this.countryCode; }
    public void setCountryCode(Object countryCode) {
        this.countryCode = countryCode; }
    Object countryCode;
}
