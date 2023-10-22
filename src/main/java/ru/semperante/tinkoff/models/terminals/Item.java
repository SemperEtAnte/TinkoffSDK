package ru.semperante.tinkoff.models.terminals;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public final class Item {
   private String Name;
   private Long Price;
   private Double Quantity;
   private Long Amount;

   private PaymentMethod PaymentMethod;
   private PaymentObject PaymentObject;
   private Tax Tax;
   private String Ean13;
   private String ShopCode;
   private AgentData AgentData;
   private ru.semperante.tinkoff.models.terminals.SupplierInfo SupplierInfo;


   public Item() {
   }

   public Item(String name, Long price, Double quantity, Long amount, Item.Tax tax) {
      Name = name;
      Price = price;
      Quantity = quantity;
      Amount = amount;
      Tax = tax;
   }

   public String getName() {
      return Name;
   }

   public Item setName(String name) {
      Name = name;
      return this;
   }

   public Long getPrice() {
      return Price;
   }

   public Item setPrice(Long price) {
      Price = price;
      return this;
   }

   public Double getQuantity() {
      return Quantity;
   }

   public Item setQuantity(Double quantity) {
      Quantity = quantity;
      return this;
   }

   public Long getAmount() {
      return Amount;
   }

   public Item setAmount(Long amount) {
      Amount = amount;
      return this;
   }

   public Item.PaymentMethod getPaymentMethod() {
      return PaymentMethod;
   }

   public Item setPaymentMethod(Item.PaymentMethod paymentMethod) {
      PaymentMethod = paymentMethod;
      return this;
   }

   public Item.PaymentObject getPaymentObject() {
      return PaymentObject;
   }

   public Item setPaymentObject(Item.PaymentObject paymentObject) {
      PaymentObject = paymentObject;
      return this;
   }

   public Item.Tax getTax() {
      return Tax;
   }

   public Item setTax(Item.Tax tax) {
      Tax = tax;
      return this;
   }

   public String getEan13() {
      return Ean13;
   }

   public Item setEan13(String ean13) {
      Ean13 = ean13;
      return this;
   }

   public String getShopCode() {
      return ShopCode;
   }

   public Item setShopCode(String shopCode) {
      ShopCode = shopCode;
      return this;
   }

   public ru.semperante.tinkoff.models.terminals.AgentData getAgentData() {
      return AgentData;
   }

   public Item setAgentData(ru.semperante.tinkoff.models.terminals.AgentData agentData) {
      AgentData = agentData;
      return this;
   }

   public ru.semperante.tinkoff.models.terminals.SupplierInfo getSupplierInfo() {
      return SupplierInfo;
   }

   public Item setSupplierInfo(ru.semperante.tinkoff.models.terminals.SupplierInfo supplierInfo) {
      SupplierInfo = supplierInfo;
      return this;
   }

   public enum PaymentMethod {
      full_payment, full_prepayment, prepayment, advance, partial_payment, credit, credit_payment
   }

   public enum PaymentObject {
      commodity, excise, job, service, gambling_bet, gambling_prize, lottery, lottery_prize, intellectual_activity, payment, agent_commission, composite, another
   }

   public enum Tax {
      none, vat0, vat10, vat20, vat110, vat120
   }
}
