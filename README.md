# FabrickTest
Fabrick Interview test

#START APPLICATION
mvn spring-boot:run

# API

/balance : ritorna il saldo per l'account ID in input

/transactions : ritorna la lista di operazioni per l'account ID in input

/moneytransfer : salva un operazione.
 
body : {
         "creditor": {
           "name": "John Doe",
           "account": {
             "accountCode": "IT23A0336844430152923804660",
             "bicCode": "SELBIT2BXXX"
           },
           "address": {
             "address": null,
             "city": null,
             "countryCode": null
           }
         },
         "executionDate": "2019-04-01",
         "uri": "REMITTANCE_INFORMATION",
         "description": "Payment invoice 75/2017",
         "amount": 800,
         "currency": "EUR",
         "isUrgent": false,
         "isInstant": false,
         "feeType": "SHA",
         "feeAccountId": "45685475",
         "taxRelief": {
           "taxReliefId": "L449",
           "isCondoUpgrade": false,
           "creditorFiscalCode": "56258745832",
           "beneficiaryType": "NATURAL_PERSON",
           "naturalPersonBeneficiary": {
             "fiscalCode1": "MRLFNC81L04A859L",
             "fiscalCode2": null,
             "fiscalCode3": null,
             "fiscalCode4": null,
             "fiscalCode5": null
           },
           "legalPersonBeneficiary": {
             "fiscalCode": null,
             "legalRepresentativeFiscalCode": null
           }
         }
       }

/localtransactions : ritorna la lista di operazioni salvate sul db.

# Properties
All'interno del file application.properties sono presenti le properties del progetto

