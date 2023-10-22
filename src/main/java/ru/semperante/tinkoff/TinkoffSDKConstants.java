package ru.semperante.tinkoff;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.jboss.logging.Logger;

import java.net.http.HttpClient;

/**
 * @author SemperAnte
 * @version 1.1
 * @since 1.0
 * Класс ютилити с константами
 */
public class TinkoffSDKConstants {

   /**
    * Клиент для отправки REST запросов
    */
   public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().build();
   /**
    * Логер, аналогичный тому что в спринге
    */
   public static final Logger LOGGER = Logger.getLogger("TinkoffAPI");

   public static final Validator VALIDATOR = Validation.buildDefaultValidatorFactory().getValidator();


}
