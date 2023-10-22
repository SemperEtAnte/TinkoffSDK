package ru.semperante.tinkoff.models.terminals;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public enum PaymentStatus {
   NEW,
   FORM_SHOWED,
   AUTHORIZING,
   @JsonProperty("3DS_CHECKING")
   TDS_CHECKING,
   @JsonProperty("3DS_CHECKED")
   TDS_CHECKED,
   AUTHORIZED,
   CONFIRMING,
   CONFIRMED,
   REVERSING,
   PARTIAL_REVERSED,
   REVERSED,
   REFUNDING,
   PARTIAL_REFUNDED,
   REFUNDED,
   CANCELED,
   DEADLINE_EXPIRED,

   REJECTED,
   AUTH_FAIL

}
