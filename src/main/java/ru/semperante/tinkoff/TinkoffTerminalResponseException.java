package ru.semperante.tinkoff;

import com.fasterxml.jackson.core.JsonProcessingException;
import ru.semperante.tinkoff.models.terminals.response.ATerminalResponse;

/**
 * @author SemperAnte
 * @version 1.1
 * @since 1.0
 * Ошибка отправки запроса на Тинькофф.
 * Выбрасывается если в ответе прилетел Error Code != 0 или Success = false
 * Заведен просто чтобы красиво вывести ошибку в stacktrace
 */
public class TinkoffTerminalResponseException extends RuntimeException {

   /**
    * Тело ответа с ошибкой
    */
   private final ATerminalResponse response;

   public TinkoffTerminalResponseException(ATerminalResponse response) throws JsonProcessingException {
      super("Error in Tinkoff response.\nError code: %s\nError Message: %s\nError Details: %s\nResponse body: %s".formatted(
              response.getErrorCode(), response.getMessage(), response.getDetails(), TinkoffTerminalApi.MAPPER.writeValueAsString(response)));
      this.response = response;
   }

   public ATerminalResponse getResponse() {
      return response;
   }
}
