package com.fabrick.testinterview.banckaccount.domain.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TaxRelief {
    @JsonProperty("taxReliefId")
    public String getTaxReliefId() {
        return this.taxReliefId; }
    public void setTaxReliefId(String taxReliefId) {
        this.taxReliefId = taxReliefId; }
    String taxReliefId;
    @JsonProperty("isCondoUpgrade")
    public boolean getIsCondoUpgrade() {
        return this.isCondoUpgrade; }
    public void setIsCondoUpgrade(boolean isCondoUpgrade) {
        this.isCondoUpgrade = isCondoUpgrade; }
    boolean isCondoUpgrade;
    @JsonProperty("creditorFiscalCode")
    public String getCreditorFiscalCode() {
        return this.creditorFiscalCode; }
    public void setCreditorFiscalCode(String creditorFiscalCode) {
        this.creditorFiscalCode = creditorFiscalCode; }
    String creditorFiscalCode;
    @JsonProperty("beneficiaryType")
    public String getBeneficiaryType() {
        return this.beneficiaryType; }
    public void setBeneficiaryType(String beneficiaryType) {
        this.beneficiaryType = beneficiaryType; }
    String beneficiaryType;
    @JsonProperty("naturalPersonBeneficiary")
    public NaturalPersonBeneficiary getNaturalPersonBeneficiary() {
        return this.naturalPersonBeneficiary; }
    public void setNaturalPersonBeneficiary(NaturalPersonBeneficiary naturalPersonBeneficiary) {
        this.naturalPersonBeneficiary = naturalPersonBeneficiary; }
    NaturalPersonBeneficiary naturalPersonBeneficiary;
    @JsonProperty("legalPersonBeneficiary")
    public LegalPersonBeneficiary getLegalPersonBeneficiary() {
        return this.legalPersonBeneficiary; }
    public void setLegalPersonBeneficiary(LegalPersonBeneficiary legalPersonBeneficiary) {
        this.legalPersonBeneficiary = legalPersonBeneficiary; }
    LegalPersonBeneficiary legalPersonBeneficiary;
}
