package ru.semperante.tinkoff.models.terminals.receipt;

import com.fasterxml.jackson.annotation.JsonGetter;

import java.util.List;

public abstract class AReceipt<T extends AItem> {

   protected String Email;
   protected String Phone;

   protected Taxation Taxation;
   protected Payments Payments;


   @JsonGetter("FfdVersion")
   public abstract String getFfdVersion();

   @JsonGetter("Items")
   public abstract List<T> getItems();

   public abstract AReceipt<T> setItems(List<T> items);

   public String getEmail() {
      return Email;
   }

   public AReceipt<T> setEmail(String email) {
      Email = email;
      return this;
   }

   public String getPhone() {
      return Phone;
   }

   public AReceipt<T> setPhone(String phone) {
      Phone = phone;
      return this;
   }

   public AReceipt.Taxation getTaxation() {
      return Taxation;
   }

   public AReceipt<T> setTaxation(AReceipt.Taxation taxation) {
      Taxation = taxation;
      return this;
   }

   public ru.semperante.tinkoff.models.terminals.receipt.Payments getPayments() {
      return Payments;
   }

   public AReceipt<T> setPayments(ru.semperante.tinkoff.models.terminals.receipt.Payments payments) {
      Payments = payments;
      return this;
   }

   public AReceipt<T> setItems(T... items) {
      setItems(List.of(items));
      return this;
   }

   public enum Taxation {
      osn, usn_income, usn_income_outcome, envd, esn, patent
   }
}
