package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NaturalPersonBeneficiary {

    @JsonProperty("fiscalCode1")
    public String getFiscalCode1() {
        return this.fiscalCode1; }
    public void setFiscalCode1(String fiscalCode1) {
        this.fiscalCode1 = fiscalCode1; }
    String fiscalCode1;
    @JsonProperty("fiscalCode2")
    public Object getFiscalCode2() {
        return this.fiscalCode2; }
    public void setFiscalCode2(Object fiscalCode2) {
        this.fiscalCode2 = fiscalCode2; }
    Object fiscalCode2;
    @JsonProperty("fiscalCode3")
    public Object getFiscalCode3() {
        return this.fiscalCode3; }
    public void setFiscalCode3(Object fiscalCode3) {
        this.fiscalCode3 = fiscalCode3; }
    Object fiscalCode3;
    @JsonProperty("fiscalCode4")
    public Object getFiscalCode4() {
        return this.fiscalCode4; }
    public void setFiscalCode4(Object fiscalCode4) {
        this.fiscalCode4 = fiscalCode4; }
    Object fiscalCode4;
    @JsonProperty("fiscalCode5")
    public Object getFiscalCode5() {
        return this.fiscalCode5; }
    public void setFiscalCode5(Object fiscalCode5) {
        this.fiscalCode5 = fiscalCode5; }
    Object fiscalCode5;
}
