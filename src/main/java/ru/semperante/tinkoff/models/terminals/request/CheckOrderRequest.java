package ru.semperante.tinkoff.models.terminals.request;

import ru.semperante.tinkoff.ATerminalRequest;
import ru.semperante.tinkoff.models.terminals.Order;
import ru.semperante.tinkoff.models.terminals.response.ATerminalResponse;
import ru.semperante.tinkoff.models.terminals.response.CheckOrderResponse;

/**
 * @author SemperAnte
 * @version 1.0
 * Тело запроса на проверку статуса заказа
 */
public class CheckOrderRequest extends ATerminalRequest {
   private Long OrderId;

   public static CheckOrderRequest buildFromOrder(Order order) {
      return new CheckOrderRequest().setOrderId(order.getId());
   }

   public Long getOrderId() {
      return OrderId;
   }

   public CheckOrderRequest setOrderId(Long orderId) {
      OrderId = orderId;
      return this;
   }

   @Override
   public Class<? extends ATerminalResponse> responseType() {
      return CheckOrderResponse.class;
   }

   @Override
   public String routing() {
      return "CheckOrder";
   }

}
