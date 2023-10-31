package ru.semperante.tinkoff.models.terminals.response;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Абстрактный класс-dto ответа от Тинькофф
 * Описанные тут поля ВСЕГДА присутствует в ответе от API терминалов, потому вынесены в класс-родитель остальных dto ответов.
 * <p>
 * Более подробно о полях в <a href="https://www.tinkoff.ru/kassa/dev/payments/">документации</a>
 */
public abstract class ATerminalResponse {
   /**
    * Ключ терминала
    */
   private String TerminalKey;
   /**
    * Сообщение ошибки
    */
   private String Message;
   /**
    * Детали ошибки
    */
   private String Details;
   /**
    * Код ошибки (=0 если ошибок нет)
    */
   private String ErrorCode;
   /**
    * Успешность запроса (=true если ошибок нет)
    */
   private Boolean Success;


   public String getTerminalKey() {
      return TerminalKey;
   }

   public void setTerminalKey(String terminalKey) {
      TerminalKey = terminalKey;
   }

   public String getMessage() {
      return Message;
   }

   public void setMessage(String message) {
      Message = message;
   }

   public String getDetails() {
      return Details;
   }

   public void setDetails(String details) {
      Details = details;
   }

   public String getErrorCode() {
      return ErrorCode;
   }

   public void setErrorCode(String errorCode) {
      ErrorCode = errorCode;
   }

   public Boolean getSuccess() {
      return Success;
   }

   public void setSuccess(Boolean success) {
      Success = success;
   }
}
