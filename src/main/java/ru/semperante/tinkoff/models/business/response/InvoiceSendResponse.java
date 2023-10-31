package ru.semperante.tinkoff.models.business.response;

import java.util.UUID;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 * Ответ на "выставить счет".
 * <p>
 * Ознакомиться с описанием можно <a href="https://developer.tinkoff.ru/docs/api/post-api-v-1-invoice-send">тут</a>
 */
public class InvoiceSendResponse extends ABusinessResponse {
   private String pdfUrl;
   private UUID invoiceId;

   public String getPdfUrl() {
      return pdfUrl;
   }

   public void setPdfUrl(String pdfUrl) {
      this.pdfUrl = pdfUrl;
   }

   public UUID getInvoiceId() {
      return invoiceId;
   }

   public void setInvoiceId(UUID invoiceId) {
      this.invoiceId = invoiceId;
   }
}
