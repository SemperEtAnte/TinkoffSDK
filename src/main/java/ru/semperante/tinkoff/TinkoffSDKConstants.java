package ru.semperante.tinkoff;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.PropertyNamingStrategies;
import org.jboss.logging.Logger;

import java.net.http.HttpClient;
/**
 * @author SemperAnte
 * @version 1.0
 * Класс ютилити с константами
 */
public class TinkoffSDKConstants {
   /**
    * Маппер - для работы с JSON
    */
   public static final ObjectMapper MAPPER = new ObjectMapper()
           .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
           .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true)
           .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
           .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
           .setSerializationInclusion(JsonInclude.Include.NON_NULL)
           .setPropertyNamingStrategy(new PropertyNamingStrategies.UpperCamelCaseStrategy());
   /**
    * Клиент для отправки REST запросов
    */
   public static final HttpClient HTTP_CLIENT = HttpClient.newBuilder().build();
   /**
    * Логер, аналогичный тому что в спринге
    */
   public static final Logger LOGGER = Logger.getLogger("TinkoffAPI");


}
