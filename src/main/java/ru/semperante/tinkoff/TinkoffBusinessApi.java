package ru.semperante.tinkoff;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import ru.semperante.tinkoff.models.business.response.ABusinessResponse;

import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author SemperAnte
 * @version 1.1
 * @since 1.0
 * Класс для отправки запросов на API для бизнеса
 */
public class TinkoffBusinessApi {
   static final ObjectMapper MAPPER = new ObjectMapper()
           .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
           .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true)
           .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
           .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
           .setSerializationInclusion(JsonInclude.Include.NON_NULL);
   private final String authorization;
   private URI baseUrl = URI.create("https://business.tinkoff.ru/openapi/api/v1/openapi/");

   public TinkoffBusinessApi(String authorization) {

      if (authorization == null || authorization.isBlank()) {
         throw new IllegalArgumentException("Authorization is null!");
      }
      this.authorization = "Bearer " + authorization;
   }

   public static String objectToParams(ObjectNode on) {
      StringBuilder result = new StringBuilder();
      boolean found = false;
      for (Iterator<String> it = on.fieldNames(); it.hasNext(); ) {
         String field = it.next();
         JsonNode val = on.get(field);
         if (val != null && val.isValueNode() && !val.isNull()) {
            if (!found) {
               result.append("?");
               found = true;
            } else {
               result.append("&");
            }
            result.append(field).append("=").append(URLEncoder.encode(val.asText(), StandardCharsets.UTF_8));
         }
      }
      return result.toString();
   }
   public static String objectToParams(Object on) {
      return objectToParams(MAPPER.convertValue(on, ObjectNode.class));
   }
   /**
    * На случай если корень api поменяется
    *
    * @param url ссылка-корень для запросов
    */
   public void setBaseUrl(String url) {
      this.baseUrl = URI.create(url);
   }

   /**
    * Отправка запроса
    *
    * @param request Тело запроса
    * @param <T>     Тип ответа определяемый в запросе
    * @return Ответ типа T
    * @throws IOException          Ошибка отправки
    * @throws InterruptedException Поток умер раньше нужного
    */
   public <T extends ABusinessResponse> T sendRequest(ABusinessRequest request) throws IOException, InterruptedException {
      return sendRequest(request, MAPPER.constructType(request.responseType()));
   }

   /**
    * Отправка запроса (любого)
    *
    * @param request      Модель запроса
    * @param responseType ожидаемый возвращаемый тип
    * @param <T>          Ожидаемый тип
    * @return Ответ ожидаемого типа
    * @throws IOException          Ошибка отправки
    * @throws InterruptedException Поток умер раньше нужного
    */
   @SuppressWarnings("uncheked")
   private <T extends ABusinessResponse> T sendRequest(ABusinessRequest request, JavaType responseType) throws IOException, InterruptedException {
      Set<ConstraintViolation<ABusinessRequest>> validationErrors = TinkoffSDKConstants.VALIDATOR.validate(request);
      if (validationErrors != null && !validationErrors.isEmpty()) {
         StringBuilder sb = new StringBuilder("Validation error:\n");
         for (ConstraintViolation<ABusinessRequest> error : validationErrors) {
            sb.append(error.getMessage()).append("\n");
         }
         throw new ValidationException(sb.toString());
      }
      String routing = request.routing();
      HttpRequest.BodyPublisher bp = HttpRequest.BodyPublishers.noBody();
      ObjectNode on = MAPPER.convertValue(request, ObjectNode.class);
      switch (request.method()) {
         case "GET", "DELETE" -> routing += objectToParams(on);
         case "POST", "PUT", "PATCH" -> {
            bp = HttpRequest.BodyPublishers.ofString(on.toString());
         }
         default -> throw new IllegalArgumentException("Unsupported method " + request.method());
      }
      HttpRequest req = HttpRequest.newBuilder()
              .uri(baseUrl.resolve(routing.toString()))
              .method(request.method(), bp)
              .header("Accept", "application/json")
              .header("Authorization", authorization)
              .build();
      TinkoffSDKConstants.LOGGER.debugf("Sending tinkoff request: %s", on);
      HttpResponse<String> response = TinkoffSDKConstants.HTTP_CLIENT.send(req, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
      if (response.statusCode() != 200) {
         TinkoffSDKConstants.LOGGER.errorf("Tinkoff response isn't 200. Code: %d.\nRequest Body: %s\nResponse body: %s", response.statusCode(), on, response.body());
         throw new IOException("Response isn't 200");
      }
      if (responseType != null) {
         T res = MAPPER.readValue(response.body(), responseType);
         if (res.getErrorCode() == null || !"0".equals(res.getErrorCode())) {
            throw new TinkoffBusinessResponseException(res);
         }
         return res;
      }
      return null;
   }
}
