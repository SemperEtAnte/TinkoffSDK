package ru.semperante.tinkoff;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.*;
import com.fasterxml.jackson.databind.node.ObjectNode;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.ValidationException;
import ru.semperante.tinkoff.models.terminals.PaymentNotificationBody;
import ru.semperante.tinkoff.models.terminals.response.ATerminalResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.*;

/**
 * @author SemperAnte
 * @version 1.1
 * @since 1.0
 * Класс для отправки запросов на API для терминалов
 */
public class TinkoffTerminalApi {
   /**
    * Маппер - для работы с JSON
    */
   static final ObjectMapper MAPPER = new ObjectMapper()
           .configure(JsonParser.Feature.IGNORE_UNDEFINED, true)
           .configure(JsonGenerator.Feature.IGNORE_UNKNOWN, true)
           .configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false)
           .configure(DeserializationFeature.FAIL_ON_IGNORED_PROPERTIES, false)
           .setSerializationInclusion(JsonInclude.Include.NON_NULL)
           .setPropertyNamingStrategy(new PropertyNamingStrategies.UpperCamelCaseStrategy());
   private final String terminalKey;
   private final String password;

   private URI baseUrl = URI.create("https://securepay.tinkoff.ru/v2/");

   public TinkoffTerminalApi(String terminalKey, String password) {
      this.terminalKey = terminalKey;
      this.password = password;
      if (terminalKey == null || password == null) {
         throw new IllegalArgumentException("Terminal key or password is null!");
      }
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
   public <T extends ATerminalResponse> T sendRequest(ATerminalRequest request) throws IOException, InterruptedException {
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
   private <T extends ATerminalResponse> T sendRequest(ATerminalRequest request, JavaType responseType) throws IOException, InterruptedException {
      request.setTerminalKey(terminalKey);
      makeToken(request);
      Set<ConstraintViolation<ATerminalRequest>> validationErrors = TinkoffSDKConstants.VALIDATOR.validate(request);
      if (validationErrors != null && !validationErrors.isEmpty()) {
         StringBuilder sb = new StringBuilder("Validation error:\n");
         for (ConstraintViolation<ATerminalRequest> error : validationErrors) {
            sb.append(error.getMessage()).append("\n");
         }
         throw new ValidationException(sb.toString());
      }
      String jsonBody = MAPPER.writeValueAsString(request);
      HttpRequest req = HttpRequest.newBuilder()
              .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
              .uri(baseUrl.resolve(request.routing()))
              .header("Content-Type", "application/json")
              .header("Accept", "application/json")
              .build();
      TinkoffSDKConstants.LOGGER.debugf("Sending tinkoff request: %s", jsonBody);
      HttpResponse<String> response = TinkoffSDKConstants.HTTP_CLIENT.send(req, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
      if (response.statusCode() != 200) {
         TinkoffSDKConstants.LOGGER.errorf("Tinkoff response isn't 200. Code: %d.\nRequest Body: %s\nResponse body: %s", response.statusCode(), jsonBody, response.body());
         throw new IOException("Response isn't 200");
      }

      TinkoffSDKConstants.LOGGER.infof("Request: %s\nResponse: %s", jsonBody, response.body());
      if (responseType != null) {
         T res = MAPPER.readValue(response.body(), responseType);
         if (res.getSuccess() == null || !res.getSuccess() || (res.getErrorCode() != null && !"0".equals(res.getErrorCode()))) {
            throw new TinkoffTerminalResponseException(res);
         }
         return res;
      }
      return null;
   }

   /**
    * Метод вычисляющий и добавляющий в тело запроса поле Token
    *
    * @param body Оригинальное тело запроса
    */
   private void makeToken(ATerminalRequest body) {
      body.setToken(calculateToken(MAPPER.convertValue(body, ObjectNode.class)));
   }

   /**
    * Ютилити метод для проверки валидности тела "уведомления"
    *
    * @param paymentNotificationBody тело уведомления
    * @return строка-токен
    */
   public String calculateToken(PaymentNotificationBody paymentNotificationBody) {
      return calculateToken(MAPPER.convertValue(paymentNotificationBody, ObjectNode.class));
   }

   /**
    * Вычисление токена для кастомного объекта (на всякий случай)
    * @param res Объект ковертированный в ObjectNode
    * @return Токен
    */
   public String calculateToken(ObjectNode res) {
      SortedMap<String, String> values = new TreeMap<>();
      Iterator<Map.Entry<String, JsonNode>> fields = res.fields();
      while (fields.hasNext()) {
         Map.Entry<String, JsonNode> field = fields.next();
         if (field.getValue() != null && field.getValue().isValueNode()) {
            values.put(field.getKey(), field.getValue().asText());
         }
      }
      values.put("Password", password);
      values.remove("Token");
      String token = String.join("", values.values());
      try {
         byte[] digest = MessageDigest.getInstance("SHA-256").digest(token.getBytes(StandardCharsets.UTF_8));
         return String.format("%064x", new BigInteger(1, digest));
      }
      catch (NoSuchAlgorithmException e) {
         throw new RuntimeException(e);
      }
   }
}
