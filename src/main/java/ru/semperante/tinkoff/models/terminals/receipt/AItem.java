package ru.semperante.tinkoff.models.terminals.receipt;

public abstract class AItem {
   protected String Name;
   protected Long Price;
   protected Double Quantity;
   protected Long Amount;

   protected ItemFfd105.PaymentMethod PaymentMethod;
   protected Tax Tax;
   protected AgentData AgentData;
   protected SupplierInfo SupplierInfo;

   public String getName() {
      return Name;
   }

   public AItem setName(String name) {
      Name = name;
      return this;
   }

   public Long getPrice() {
      return Price;
   }

   public AItem setPrice(Long price) {
      Price = price;
      return this;
   }

   public Double getQuantity() {
      return Quantity;
   }

   public AItem setQuantity(Double quantity) {
      Quantity = quantity;
      return this;
   }

   public Long getAmount() {
      return Amount;
   }

   public AItem setAmount(Long amount) {
      Amount = amount;
      return this;
   }

   public ItemFfd105.PaymentMethod getPaymentMethod() {
      return PaymentMethod;
   }

   public AItem setPaymentMethod(ItemFfd105.PaymentMethod paymentMethod) {
      PaymentMethod = paymentMethod;
      return this;
   }

   public AItem.Tax getTax() {
      return Tax;
   }

   public AItem setTax(AItem.Tax tax) {
      Tax = tax;
      return this;
   }

   public ru.semperante.tinkoff.models.terminals.receipt.AgentData getAgentData() {
      return AgentData;
   }

   public AItem setAgentData(ru.semperante.tinkoff.models.terminals.receipt.AgentData agentData) {
      AgentData = agentData;
      return this;
   }

   public ru.semperante.tinkoff.models.terminals.receipt.SupplierInfo getSupplierInfo() {
      return SupplierInfo;
   }

   public AItem setSupplierInfo(ru.semperante.tinkoff.models.terminals.receipt.SupplierInfo supplierInfo) {
      SupplierInfo = supplierInfo;
      return this;
   }

   public enum Tax {
      none, vat0, vat10, vat20, vat110, vat120
   }
   public enum PaymentMethod {
      full_payment, full_prepayment, prepayment, advance, partial_payment, credit, credit_payment
   }

}
