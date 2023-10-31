package ru.semperante.tinkoff.models.terminals.request;

import jakarta.validation.constraints.NotNull;
import ru.semperante.tinkoff.ATerminalRequest;
import ru.semperante.tinkoff.models.terminals.Order;
import ru.semperante.tinkoff.models.terminals.response.ATerminalResponse;
import ru.semperante.tinkoff.models.terminals.response.GetStateResponse;

import java.math.BigInteger;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Запрос на проверку статуса платежа
 */
public final class GetStateRequest extends ATerminalRequest {
   @NotNull
   private BigInteger PaymentId;

   private String Ip;

   public static GetStateRequest buildFromOrder(Order order) {
      return new GetStateRequest().setPaymentId(order.getTinkoffId());
   }

   public BigInteger getPaymentId() {
      return PaymentId;
   }

   public GetStateRequest setPaymentId(BigInteger paymentId) {
      PaymentId = paymentId;
      return this;
   }

   public String getIp() {
      return Ip;
   }

   public GetStateRequest setIp(String ip) {
      Ip = ip;
      return this;
   }

   @Override
   public Class<? extends ATerminalResponse> responseType() {
      return GetStateResponse.class;
   }

   @Override
   public String routing() {
      return "GetState";
   }
}
