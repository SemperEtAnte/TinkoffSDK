package ru.semperante.tinkoff.models.terminals.response;

import java.math.BigInteger;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Ответ на запрос Init
 */
public final class InitResponse extends ATerminalResponse {
   private Long Amount;
   private Long OrderId;
   private String Status;
   private BigInteger PaymentId;
   private String PaymentURL;

   public Long getAmount() {
      return Amount;
   }

   public void setAmount(Long amount) {
      Amount = amount;
   }

   public Long getOrderId() {
      return OrderId;
   }

   public void setOrderId(Long orderId) {
      OrderId = orderId;
   }

   public String getStatus() {
      return Status;
   }

   public void setStatus(String status) {
      Status = status;
   }

   public BigInteger getPaymentId() {
      return PaymentId;
   }

   public void setPaymentId(BigInteger paymentId) {
      PaymentId = paymentId;
   }

   public String getPaymentURL() {
      return PaymentURL;
   }

   public void setPaymentURL(String paymentURL) {
      PaymentURL = paymentURL;
   }
}
