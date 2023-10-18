package ru.semperante.tinkoff.models.terminals.response;

import ru.semperante.tinkoff.models.terminals.PaymentStatus;

import java.math.BigInteger;
import java.util.List;
/**
 * @author SemperAnte
 * @version 1.0
 * Ответ на запрос GetState
 */
public final class GetStateResponse extends ATerminalResponse {
   private Long Amount;
   private Long OrderId;
   private PaymentStatus Status;
   private BigInteger PaymentId;
   private List<ItemsParams> Params;

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

   public PaymentStatus getStatus() {
      return Status;
   }

   public void setStatus(PaymentStatus status) {
      Status = status;
   }

   public BigInteger getPaymentId() {
      return PaymentId;
   }

   public void setPaymentId(BigInteger paymentId) {
      PaymentId = paymentId;
   }

   public List<ItemsParams> getParams() {
      return Params;
   }

   public void setParams(List<ItemsParams> params) {
      Params = params;
   }

   public enum Route {
      TCB,
      BNPL
   }

   public enum Source {
      installment, BNPL
   }

   public record ItemsParams(Route Route, Source Source, Long CreditAmount) {

   }
}
