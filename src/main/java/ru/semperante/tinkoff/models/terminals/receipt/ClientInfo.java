package ru.semperante.tinkoff.models.terminals.receipt;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class ClientInfo {
   @JsonFormat(pattern = "dd.MM.yyyy")
   private Date Birthdate;
   private String Citizenship;
   private String DocumentCode;
   private String DocumentData;
   private String Address;

   public Date getBirthdate() {
      return Birthdate;
   }

   public ClientInfo setBirthdate(Date birthdate) {
      Birthdate = birthdate;
      return this;
   }

   public String getCitizenship() {
      return Citizenship;
   }

   public ClientInfo setCitizenship(String citizenship) {
      Citizenship = citizenship;
      return this;
   }

   public String getDocumentCode() {
      return DocumentCode;
   }

   public ClientInfo setDocumentCode(String documentCode) {
      DocumentCode = documentCode;
      return this;
   }

   public String getDocumentData() {
      return DocumentData;
   }

   public ClientInfo setDocumentData(String documentData) {
      DocumentData = documentData;
      return this;
   }

   public String getAddress() {
      return Address;
   }

   public ClientInfo setAddress(String address) {
      Address = address;
      return this;
   }
}
