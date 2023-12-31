package ru.semperante.tinkoff.models.business.request;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.semperante.tinkoff.ABusinessRequest;
import ru.semperante.tinkoff.models.business.response.ABusinessResponse;
import ru.semperante.tinkoff.models.business.response.InvoiceInfoResponse;

import java.util.UUID;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 * Запрос статуса выставленного счета.
 * <p>
 * Ознакомиться с описанием можно <a href="https://developer.tinkoff.ru/docs/api/get-api-v-1-invoice-invoice-id-info">тут</a>
 */
public class InvoiceInfoRequest extends ABusinessRequest {
   @JsonIgnore
   private UUID invoiceId;

   public InvoiceInfoRequest() {
   }

   public InvoiceInfoRequest(UUID invoiceId) {
      this.invoiceId = invoiceId;
   }

   public UUID getInvoiceId() {
      return invoiceId;
   }

   public InvoiceInfoRequest setInvoiceId(UUID invoiceId) {
      this.invoiceId = invoiceId;
      return this;
   }

   @Override
   public Class<? extends ABusinessResponse> responseType() {
      return InvoiceInfoResponse.class;
   }

   @Override
   public String routing() {
      return "openapi/invoice/" + invoiceId + "/info";
   }

   @Override
   public String method() {
      return "GET";
   }
}
