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

   public String getPhone() {
      return Phone;
   }

   public AReceipt.Taxation getTaxation() {
      return Taxation;
   }

   public Payments getPayments() {
      return Payments;
   }

   public enum Taxation {
      osn, usn_income, usn_income_outcome, envd, esn, patent
   }
}
