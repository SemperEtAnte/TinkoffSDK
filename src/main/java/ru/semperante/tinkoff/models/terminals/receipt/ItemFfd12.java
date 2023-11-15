package ru.semperante.tinkoff.models.terminals.receipt;

public class ItemFfd12 extends AItem {
   private PaymentObject PaymentObject;
   private String UserData;
   private String Excise;
   private String CountryCode;
   private String DeclarationNumber;
   private String MeasurementUnit;
   private String MarkProcessingMode;
   private MarkCode MarkCode;

   private MarkQuantity MarkQuantity;
   private SectoralItemProps SectoralItemProps;

   public ItemFfd12.PaymentObject getPaymentObject() {
      return PaymentObject;
   }

   public ItemFfd12 setName(String name) {
      Name = name;
      return this;
   }

   public ItemFfd12 setPrice(Long price) {
      Price = price;
      return this;
   }

   public ItemFfd12 setQuantity(Double quantity) {
      Quantity = quantity;
      return this;
   }

   public ItemFfd12 setAmount(Long amount) {
      Amount = amount;
      return this;
   }

   public ItemFfd12 setPaymentMethod(ItemFfd105.PaymentMethod paymentMethod) {
      PaymentMethod = paymentMethod;
      return this;
   }

   public ItemFfd12 setTax(AItem.Tax tax) {
      Tax = tax;
      return this;
   }

   public ItemFfd12 setAgentData(ru.semperante.tinkoff.models.terminals.receipt.AgentData agentData) {
      AgentData = agentData;
      return this;
   }

   public ItemFfd12 setSupplierInfo(ru.semperante.tinkoff.models.terminals.receipt.SupplierInfo supplierInfo) {
      SupplierInfo = supplierInfo;
      return this;
   }

   public ItemFfd12 setPaymentObject(ItemFfd12.PaymentObject paymentObject) {
      PaymentObject = paymentObject;
      return this;
   }

   public String getUserData() {
      return UserData;
   }

   public ItemFfd12 setUserData(String userData) {
      UserData = userData;
      return this;
   }

   public String getExcise() {
      return Excise;
   }

   public ItemFfd12 setExcise(String excise) {
      Excise = excise;
      return this;
   }

   public String getCountryCode() {
      return CountryCode;
   }

   public ItemFfd12 setCountryCode(String countryCode) {
      CountryCode = countryCode;
      return this;
   }

   public String getDeclarationNumber() {
      return DeclarationNumber;
   }

   public ItemFfd12 setDeclarationNumber(String declarationNumber) {
      DeclarationNumber = declarationNumber;
      return this;
   }

   public String getMeasurementUnit() {
      return MeasurementUnit;
   }

   public ItemFfd12 setMeasurementUnit(String measurementUnit) {
      MeasurementUnit = measurementUnit;
      return this;
   }

   public String getMarkProcessingMode() {
      return MarkProcessingMode;
   }

   public ItemFfd12 setMarkProcessingMode(String markProcessingMode) {
      MarkProcessingMode = markProcessingMode;
      return this;
   }

   public ItemFfd12.MarkCode getMarkCode() {
      return MarkCode;
   }

   public ItemFfd12 setMarkCode(ItemFfd12.MarkCode markCode) {
      MarkCode = markCode;
      return this;
   }

   public ItemFfd12.MarkQuantity getMarkQuantity() {
      return MarkQuantity;
   }

   public ItemFfd12 setMarkQuantity(ItemFfd12.MarkQuantity markQuantity) {
      MarkQuantity = markQuantity;
      return this;
   }

   public ItemFfd12.SectoralItemProps getSectoralItemProps() {
      return SectoralItemProps;
   }

   public ItemFfd12 setSectoralItemProps(ItemFfd12.SectoralItemProps sectoralItemProps) {
      SectoralItemProps = sectoralItemProps;
      return this;
   }

   public static final class SectoralItemProps {
      private String FederalId;
      private String Date;
      private String Number;
      private String Value;
   }

   public static final class MarkQuantity {

      private String Numerator;
      private String Denominator;

      public String getNumerator() {
         return Numerator;
      }

      public MarkQuantity setNumerator(String numerator) {
         Numerator = numerator;
         return this;
      }

      public String getDenominator() {
         return Denominator;
      }

      public MarkQuantity setDenominator(String denominator) {
         Denominator = denominator;
         return this;
      }

   }

   public static final class MarkCode {
      private MarkCodeType MarkCodeType;

      private String Value;

      public MarkCode.MarkCodeType getMarkCodeType() {
         return MarkCodeType;
      }

      public MarkCode setMarkCodeType(MarkCode.MarkCodeType markCodeType) {
         MarkCodeType = markCodeType;
         return this;
      }

      public String getValue() {
         return Value;
      }

      public MarkCode setValue(String value) {
         Value = value;
         return this;
      }


      public enum MarkCodeType {
         UNKNOWN,
         EAN8,
         EAN13,
         ITF14,
         GS10,
         GS1M,
         SHORT,
         FUR,
         EGAIS20,
         EGAIS30;
      }
   }

   public enum PaymentObject {
      commodity,
      excise,
      job,
      service,
      gambling_bet,
      gambling_prize,
      lottery,
      lottery_prize,
      intellectual_activity,
      payment,
      agent_commission,
      contribution,
      property_rights,
      unrealization,
      tax_reduction,
      trade_fee,
      resort_tax,
      pledge,
      income_decrease,
      ie_pension_insurance_without_payments,
      ie_pension_insurance_with_payments,
      ie_medical_insurance_without_payments,
      ie_medical_insurance_with_payments,
      social_insurance,
      casino_chips,
      agent_payment,
      excisable_goods_without_marking_code,
      excisable_goods_with_marking_code,
      goods_without_marking_code,
      goods_with_marking_code,
      another
   }

}










