package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TypeDto {

    @JsonProperty("enumeration")
    public String getEnumeration() {
        return this.enumeration; }
    public void setEnumeration(String enumeration) {
        this.enumeration = enumeration; }
    String enumeration;
    @JsonProperty("value")
    public String getValue() {
        return this.value; }
    public void setValue(String value) {
        this.value = value; }
    String value;
}
