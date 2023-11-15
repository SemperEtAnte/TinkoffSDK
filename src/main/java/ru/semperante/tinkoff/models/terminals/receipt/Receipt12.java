package ru.semperante.tinkoff.models.terminals.receipt;

import java.util.List;

public class Receipt12 extends AReceipt<ItemFfd12> {


   private List<ItemFfd12> Items;
   private ClientInfo ClientInfo;
   private String Customer;
   private String CustomerInn;

   public ru.semperante.tinkoff.models.terminals.receipt.ClientInfo getClientInfo() {
      return ClientInfo;
   }

   public Receipt12 setClientInfo(ru.semperante.tinkoff.models.terminals.receipt.ClientInfo clientInfo) {
      ClientInfo = clientInfo;
      return this;
   }

   public String getCustomer() {
      return Customer;
   }

   public Receipt12 setCustomer(String customer) {
      Customer = customer;
      return this;
   }

   public String getCustomerInn() {
      return CustomerInn;
   }

   public Receipt12 setCustomerInn(String customerInn) {
      CustomerInn = customerInn;
      return this;
   }

   @Override
   public String getFfdVersion() {
      return "1.2";
   }

   @Override
   public List<ItemFfd12> getItems() {
      return Items;
   }

   public Receipt12 setEmail(String email) {
      Email = email;
      return this;
   }

   public Receipt12 setPhone(String phone) {
      Phone = phone;
      return this;
   }

   public Receipt12 setTaxation(AReceipt.Taxation taxation) {
      Taxation = taxation;
      return this;
   }

   public Receipt12 setPayments(ru.semperante.tinkoff.models.terminals.receipt.Payments payments) {
      Payments = payments;
      return this;
   }

   @Override
   public Receipt12 setItems(List<ItemFfd12> items) {
      this.Items = items;
      return this;
   }
}
