package ru.semperante.tinkoff.models.business.response;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 * Ответ на "статус выставленного счета".
 * <p>
 * Ознакомиться с описанием можно <a href="https://developer.tinkoff.ru/docs/api/get-api-v-1-invoice-invoice-id-info">тут</a>
 */
public class InvoiceInfoResponse extends ABusinessResponse {
   private InvoiceStatus status;

   public InvoiceStatus getStatus() {
      return status;
   }

   public void setStatus(InvoiceStatus status) {
      this.status = status;
   }

   public enum InvoiceStatus {
      DRAFT, SUBMITTED, EXECUTED
   }
}
