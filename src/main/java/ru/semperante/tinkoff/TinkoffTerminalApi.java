package ru.semperante.tinkoff;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import ru.semperante.tinkoff.models.terminals.response.ATerminalResponse;

import java.io.IOException;
import java.math.BigInteger;
import java.net.URI;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

/**
 * @author SemperAnte
 * @version 1.0
 * Класс для отправки запросов на API для терминалов
 */
public class TinkoffTerminalApi {

   private static final URI BASE_URL = URI.create("https://securepay.tinkoff.ru/v2/");
   private final String terminalKey;
   private final String password;

   public TinkoffTerminalApi(String terminalKey, String password) {
      this.terminalKey = terminalKey;
      this.password = password;
      if (terminalKey == null || password == null) {
         throw new IllegalArgumentException("Terminal key or password is null!");
      }
   }


   /**
    * Отправка запроса
    * @param request Тело запроса
    * @return Ответ типа T
    * @param <T> Тип ответа определяемый в запросе
    * @throws IOException          Ошибка отправки
    * @throws InterruptedException Поток умер раньше нужного
    */
   public <T extends ATerminalResponse> T sendRequest(ATerminalRequest request) throws IOException, InterruptedException {
      return sendRequest(request, TinkoffSDKConstants.MAPPER.constructType(request.responseType()));
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
      String jsonBody = TinkoffSDKConstants.MAPPER.writeValueAsString(request);
      HttpRequest req = HttpRequest.newBuilder()
              .POST(HttpRequest.BodyPublishers.ofString(jsonBody))
              .uri(BASE_URL.resolve(request.routing()))
              .header("Content-Type", "application/json")
              .header("Accept", "application/json")
              .build();
      TinkoffSDKConstants.LOGGER.infof("Sending tinkoff request: %s", jsonBody);
      HttpResponse<String> response = TinkoffSDKConstants.HTTP_CLIENT.send(req, HttpResponse.BodyHandlers.ofString(StandardCharsets.UTF_8));
      if (response.statusCode() != 200) {
         TinkoffSDKConstants.LOGGER.errorf("Tinkoff response isn't 200. Code: %d.\nRequest Body: %s\nResponse body: %s", response.statusCode(), jsonBody, response.body());
         throw new IOException("Response isn't 200");
      }

      if (responseType != null) {
         T res = TinkoffSDKConstants.MAPPER.readValue(response.body(), responseType);
         if (res.getSuccess() == null || !res.getSuccess() || !"0".equals(res.getErrorCode())) {
            throw new TinkoffResponseException(res);
         }
         return res;
      }
      return null;
   }

   /**
    * Метод вычисляющий и добавляющий в тело запроса поле Token
    *
    * @param body Оригинальное тело запроса
    * @return Дополненное полем Token тело запроса (новый объект)
    */
   private void makeToken(ATerminalRequest body) {
      ObjectNode res = TinkoffSDKConstants.MAPPER.convertValue(body, ObjectNode.class);
      SortedMap<String, String> values = new TreeMap<>();
      Iterator<Map.Entry<String, JsonNode>> fields = res.fields();
      while (fields.hasNext()) {
         Map.Entry<String, JsonNode> field = fields.next();
         if (field.getValue() != null && field.getValue().isValueNode()) {
            values.put(field.getKey(), field.getValue().asText());
         }
      }
      values.put("Password", password);
      String token = String.join("", values.values());
      try {
         byte[] digest = MessageDigest.getInstance("SHA-256").digest(token.getBytes(StandardCharsets.UTF_8));
         token = String.format("%064x", new BigInteger(1, digest));
         body.setToken(token);
      }
      catch (NoSuchAlgorithmException e) {
         throw new RuntimeException(e);
      }
   }
}
