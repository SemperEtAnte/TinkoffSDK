package ru.semperante.tinkoff.models.terminals.response;

import ru.semperante.tinkoff.models.terminals.PaymentStatus;

import java.math.BigInteger;
import java.util.List;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Ответ на запрос CheckOrder
 */
public final class CheckOrderResponse extends ATerminalResponse {
   private Long OrderId;
   private List<PaymentCheckOrder> Payments;


   public Long getOrderId() {
      return OrderId;
   }

   public void setOrderId(Long orderId) {
      OrderId = orderId;
   }

   public List<PaymentCheckOrder> getPayments() {
      return Payments;
   }

   public void setPayments(List<PaymentCheckOrder> payments) {
      Payments = payments;
   }

   public record PaymentCheckOrder(
           BigInteger PaymentId,
           Long Amount,
           PaymentStatus Status,
           String RRN,
           Boolean Success,
           String ErrorCode,
           String Message
   ) {

   }
}
