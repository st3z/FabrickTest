package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class LegalPersonBeneficiary {

    @JsonProperty("fiscalCode")
    public Object getFiscalCode() {
        return this.fiscalCode; }
    public void setFiscalCode(Object fiscalCode) {
        this.fiscalCode = fiscalCode; }
    Object fiscalCode;
    @JsonProperty("legalRepresentativeFiscalCode")
    public Object getLegalRepresentativeFiscalCode() {
        return this.legalRepresentativeFiscalCode; }
    public void setLegalRepresentativeFiscalCode(Object legalRepresentativeFiscalCode) {
        this.legalRepresentativeFiscalCode = legalRepresentativeFiscalCode; }
    Object legalRepresentativeFiscalCode;

}
