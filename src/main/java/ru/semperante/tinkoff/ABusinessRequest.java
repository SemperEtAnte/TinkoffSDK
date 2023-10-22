package ru.semperante.tinkoff;

import com.fasterxml.jackson.annotation.JsonIgnore;
import ru.semperante.tinkoff.models.business.response.ABusinessResponse;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 */
public abstract class ABusinessRequest {

   /**
    * Ожидаемое тело ответа
    *
    * @return Класс отвечающий за тело ответа
    */
   @JsonIgnore
   public abstract Class<? extends ABusinessResponse> responseType();

   /**
    * Какой роутинг запроса (после основного роутинга API)
    *
    * @return Строка-роутинг
    */
   @JsonIgnore
   public abstract String routing();

   /**
    * HTTP метод отправки запроса (POST, GET, PATCH, DELETE, PUT)
    *
    * @return HTTP метод
    */
   @JsonIgnore
   public abstract String method();

}
