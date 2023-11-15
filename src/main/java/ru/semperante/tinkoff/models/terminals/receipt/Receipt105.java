package ru.semperante.tinkoff.models.terminals.receipt;

import java.util.List;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public class Receipt105 extends AReceipt<ItemFfd105> {
   private List<ItemFfd105> Items;

   public Receipt105() {
   }

   public Receipt105(List<ItemFfd105> items, Taxation taxation) {
      this.Items = items;
      this.Taxation = taxation;
   }

   public Receipt105 setEmail(String email) {
      Email = email;
      return this;
   }

   public Receipt105 setPhone(String phone) {
      Phone = phone;
      return this;
   }

   public Receipt105 setTaxation(AReceipt.Taxation taxation) {
      Taxation = taxation;
      return this;
   }

   public Receipt105 setPayments(ru.semperante.tinkoff.models.terminals.receipt.Payments payments) {
      Payments = payments;
      return this;
   }

   @Override
   public String getFfdVersion() {
      return "1.05";
   }

   public List<ItemFfd105> getItems() {
      return Items;
   }

   public Receipt105 setItems(List<ItemFfd105> items) {
      this.Items = items;
      return this;
   }
}
