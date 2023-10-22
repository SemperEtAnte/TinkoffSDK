package ru.semperante.tinkoff.models.business.response;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 * В классе заложено тело ответа-ошибки.
 * Если эти поля пустые, значит запрос был успешным, однако, т.к. ответ с ошибкой универсален для всех,
 * было решено вынести это как родительский класс всех ответов
 */
public abstract class ABusinessResponse {
   private String errorCode;
   private String errorId;
   private String errorMessage;
   private String errorDetails;

   public String getErrorCode() {
      return errorCode;
   }

   public void setErrorCode(String errorCode) {
      this.errorCode = errorCode;
   }

   public String getErrorId() {
      return errorId;
   }

   public void setErrorId(String errorId) {
      this.errorId = errorId;
   }

   public String getErrorMessage() {
      return errorMessage;
   }

   public void setErrorMessage(String errorMessage) {
      this.errorMessage = errorMessage;
   }

   public String getErrorDetails() {
      return errorDetails;
   }

   public void setErrorDetails(String errorDetails) {
      this.errorDetails = errorDetails;
   }
}
