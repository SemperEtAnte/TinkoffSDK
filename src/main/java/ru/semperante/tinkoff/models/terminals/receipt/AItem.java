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

   public Long getPrice() {
      return Price;
   }

   public Double getQuantity() {
      return Quantity;
   }

   public Long getAmount() {
      return Amount;
   }

   public ItemFfd105.PaymentMethod getPaymentMethod() {
      return PaymentMethod;
   }

   public AItem.Tax getTax() {
      return Tax;
   }

   public ru.semperante.tinkoff.models.terminals.receipt.AgentData getAgentData() {
      return AgentData;
   }

   public ru.semperante.tinkoff.models.terminals.receipt.SupplierInfo getSupplierInfo() {
      return SupplierInfo;
   }

   public enum Tax {
      none, vat0, vat10, vat20, vat110, vat120
   }
   public enum PaymentMethod {
      full_payment, full_prepayment, prepayment, advance, partial_payment, credit, credit_payment
   }

}
