package ru.semperante.tinkoff.models.terminals;

import java.util.List;
/**
 * @author SemperAnte
 * @version 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public class Receipt {

   private List<Item> Items;
   private String FfdVersion;
   private String Email;
   private String Phone;
   private Taxation Taxation;
   private ru.semperante.tinkoff.models.terminals.Payments Payments;

   public Receipt() {
   }

   public Receipt(List<Item> items, Taxation taxation) {
      this.Items = items;
      this.Taxation = taxation;
   }


   public List<Item> getItems() {
      return Items;
   }

   public Receipt setItems(List<Item> items) {
      Items = items;
      return this;
   }

   public Receipt setItems(Item... items) {
      return setItems(List.of(items));
   }

   public String getFfdVersion() {
      return FfdVersion;
   }

   public Receipt setFfdVersion(String ffdVersion) {
      FfdVersion = ffdVersion;
      return this;
   }

   public String getEmail() {
      return Email;
   }

   public Receipt setEmail(String email) {
      Email = email;
      return this;
   }

   public String getPhone() {
      return Phone;
   }

   public Receipt setPhone(String phone) {
      Phone = phone;
      return this;
   }

   public Receipt.Taxation getTaxation() {
      return Taxation;
   }

   public Receipt setTaxation(Receipt.Taxation taxation) {
      Taxation = taxation;
      return this;
   }

   public Payments getPayments() {
      return Payments;
   }

   public Receipt setPayments(Payments payments) {
      Payments = payments;
      return this;
   }

   public enum Taxation {
      osn, usn_income, usn_income_outcome, envd, esn, patent
   }
}
