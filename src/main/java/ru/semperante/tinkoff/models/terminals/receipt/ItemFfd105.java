package ru.semperante.tinkoff.models.terminals.receipt;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public final class ItemFfd105 extends AItem {
   private PaymentObject PaymentObject;
   private String Ean13;
   private String ShopCode;


   public ItemFfd105() {
   }

   public ItemFfd105(String name, Long price, Double quantity, Long amount, ItemFfd105.Tax tax) {
      Name = name;
      Price = price;
      Quantity = quantity;
      Amount = amount;
      Tax = tax;
   }

   public ItemFfd105.PaymentObject getPaymentObject() {
      return PaymentObject;
   }

   public ItemFfd105 setPaymentObject(ItemFfd105.PaymentObject paymentObject) {
      PaymentObject = paymentObject;
      return this;
   }

   public String getEan13() {
      return Ean13;
   }

   public ItemFfd105 setEan13(String ean13) {
      Ean13 = ean13;
      return this;
   }

   public String getShopCode() {
      return ShopCode;
   }

   public ItemFfd105 setShopCode(String shopCode) {
      ShopCode = shopCode;
      return this;
   }

   public ItemFfd105 setName(String name) {
      Name = name;
      return this;
   }

   public ItemFfd105 setPrice(Long price) {
      Price = price;
      return this;
   }

   public ItemFfd105 setQuantity(Double quantity) {
      Quantity = quantity;
      return this;
   }

   public ItemFfd105 setAmount(Long amount) {
      Amount = amount;
      return this;
   }

   public ItemFfd105 setPaymentMethod(ItemFfd105.PaymentMethod paymentMethod) {
      PaymentMethod = paymentMethod;
      return this;
   }

   public ItemFfd105 setTax(AItem.Tax tax) {
      Tax = tax;
      return this;
   }

   public ItemFfd105 setAgentData(ru.semperante.tinkoff.models.terminals.receipt.AgentData agentData) {
      AgentData = agentData;
      return this;
   }

   public ItemFfd105 setSupplierInfo(ru.semperante.tinkoff.models.terminals.receipt.SupplierInfo supplierInfo) {
      SupplierInfo = supplierInfo;
      return this;
   }

   public enum PaymentObject {
      commodity, excise, job, service, gambling_bet, gambling_prize, lottery, lottery_prize, intellectual_activity, payment, agent_commission, composite, another
   }


}
