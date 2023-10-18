package ru.semperante.tinkoff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.semperante.tinkoff.models.terminals.response.ATerminalResponse;

/**
 * @author SemperAnte
 * @version 1.0
 * Абстрактный класс-dto запроса отправляемого на API терминалов
 *
 * Более подробно о полях в <a href="https://www.tinkoff.ru/kassa/dev/payments/">документации</a>
 */
public abstract class ATerminalRequest {
   /**
    * Токен генерируемый как "защита" запроса
    */
   private String Token;
   /**
    * Ключ терминалов
    */

   private String TerminalKey;

   public String getToken() {
      return Token;
   }

   ATerminalRequest setToken(String token) {
      Token = token;
      return this;
   }

   public String getTerminalKey() {
      return TerminalKey;
   }

   ATerminalRequest setTerminalKey(String terminalKey) {
      TerminalKey = terminalKey;
      return this;
   }

   /**
    * Ожидаемое тело ответа
    * @return Класс отвечающий за тело ответа
    */
   @JsonIgnore
   public abstract Class<? extends ATerminalResponse> responseType();

   /**
    * Какой роутинг запроса (после основного роутинга API)
    * @return Строка-роутинг
    */
   @JsonIgnore
   public abstract String routing();
}
