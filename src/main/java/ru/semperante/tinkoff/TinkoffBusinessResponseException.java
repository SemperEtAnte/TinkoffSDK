package ru.semperante.tinkoff;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import ru.semperante.tinkoff.models.business.response.ABusinessResponse;

/**
 * @author SemperAnte
 * @version 2.0
 * @since 1.1
 * Ошибка отправки запроса на Тинькофф-бизнес.
 * Выбрасывается если в ответе прилетел Error Code != 0
 * Заведен просто чтобы красиво вывести ошибку в stacktrace
 */
public class TinkoffBusinessResponseException extends RuntimeException {

   /**
    * Тело ответа с ошибкой
    */
   private final ABusinessResponse response;

   public TinkoffBusinessResponseException(ABusinessResponse response) throws JsonProcessingException {
      super("Error in Tinkoff response.\nError code: %s\nError Id: %s\nError Message: %s\nError Details: %s\nResponse body: %s".formatted(
              response.getErrorCode(), response.getErrorId(), response.getErrorMessage(), response.getErrorDetails(), TinkoffBusinessApi.MAPPER.writeValueAsString(response)));
      this.response = response;
   }

   public ABusinessResponse getResponse() {
      return response;
   }
}
