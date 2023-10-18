# SDK для работы с API Tinkoff

Находится в разработке. Основная причиная создания данной репозитории - то что сам Тинькофф предоставляет некоторый SDK только для мобильных приложений, что не совсем удобно для использования в рамках Web приложений.

Пока что реализована небольшая (самая фундаментальная) часть работы с терминалами. Далее будет наращивание для использования business api (ака выставление счетов) и после, скорее всего, наращивание библиотеки запросов

## Системные требования

Проект написан с использованием:

* Gradle 8.3
* Java 17

## Подключение

Для подключения используется maven репозитория

**maven:**

```
```

**gradle:**

```
```

Основной функционал лежит в классе TinkoffTerminalApi и запросах/ответах

```java
TiknoffTerminalApi api = new TinkoffTerminalApi(terminalKey,password);
Order to = new Order(RAND.nextLong(),123L);
InitResponse initResponse=api.sendRequest(InitRequest.buildFromOrder(to)
   .setSuccessURL("http://127.0.0.1/success")
   .setFailURL("http://127.0.0.1/fail")
   .setDescription("Тестовый платеж"));
```

## Масштабирование

Т.к. SDK пока что не содержит полного набора моделей для покрытия всех возможных запросов к API Tinkoff, в ней заложен набор абстракций для легкого масштабирования.

Для того чтобы создать запрос не описанный в SDK, необходимо наследовать классы `ATerminalRequest` и `ATerminalResponse`.

`ATerminalResponse` - представляет из себя не более чем ожидаемую модель ответа от Tinkoff, которая будет считана из JSON.

`ATerminalRequest` - аналогично описывает тело запрос + в нем указется роутинг по которому отправлять запрос (его часть после основонго роутинга API терминалов) + ожидаемая модель ответа (нужна чтобы JSON знал что читать и сразу возвращал ответ нужного типа).

Но т.к. в этой части обычно все просто ищут код - вставлю сюда в качестве примера запрос `GetState`

**Request:**

```java
package ru.semperante.tinkoff.models.terminals.request;

import ru.semperante.tinkoff.ATerminalRequest;
import ru.semperante.tinkoff.models.terminals.Order;
import ru.semperante.tinkoff.models.terminals.response.ATerminalResponse;
import ru.semperante.tinkoff.models.terminals.response.GetStateResponse;

import java.math.BigInteger;

/**
 * @author SemperAnte
 * @version 1.0
 * Запрос на проверку статуса платежа
 */
public final class GetStateRequest extends ATerminalRequest {
   private BigInteger PaymentId;
   private String Ip;

   public static GetStateRequest buildFromOrder(Order order) {
      return new GetStateRequest().setPaymentId(order.getTinkoffId());
   }

   public BigInteger getPaymentId() {
      return PaymentId;
   }

   public GetStateRequest setPaymentId(BigInteger paymentId) {
      PaymentId = paymentId;
      return this;
   }

   public String getIp() {
      return Ip;
   }

   public GetStateRequest setIp(String ip) {
      Ip = ip;
      return this;
   }

   @Override
   public Class<? extends ATerminalResponse> responseType() {
      return GetStateResponse.class;
   }

   @Override
   public String routing() {
      return "GetState";
   }
}
```

**Response:**

```java
package ru.semperante.tinkoff.models.terminals.response;

import ru.semperante.tinkoff.models.terminals.PaymentStatus;

import java.math.BigInteger;
import java.util.List;

/**
 * @author SemperAnte
 * @version 1.0
 * Ответ на запрос GetState
 */
public final class GetStateResponse extends ATerminalResponse {
   private Long Amount;
   private Long OrderId;
   private PaymentStatus Status;
   private BigInteger PaymentId;
   private List<ItemsParams> Params;

   public Long getAmount() {
      return Amount;
   }

   public void setAmount(Long amount) {
      Amount = amount;
   }

   public Long getOrderId() {
      return OrderId;
   }

   public void setOrderId(Long orderId) {
      OrderId = orderId;
   }

   public PaymentStatus getStatus() {
      return Status;
   }

   public void setStatus(PaymentStatus status) {
      Status = status;
   }

   public BigInteger getPaymentId() {
      return PaymentId;
   }

   public void setPaymentId(BigInteger paymentId) {
      PaymentId = paymentId;
   }

   public List<ItemsParams> getParams() {
      return Params;
   }

   public void setParams(List<ItemsParams> params) {
      Params = params;
   }

   public enum Route {
      TCB,
      BNPL
   }

   public enum Source {
      installment, BNPL
   }

   public record ItemsParams(Route Route, Source Source, Long CreditAmount) {

   }
}
```

## Тестирование

Для запуска тестов необходимо положить `terminalKey`, `password`, `paymentId` в environment или в файлик
`src/test/resources/keys.properties` (не переживайте, он в `.gitigore`). Последний параметр - ИД тестового платежа для запроса статуса, первые 2, полагаю, вопросов не вызывают.



