package ru.semperante.tinkoff.models.terminals.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import ru.semperante.tinkoff.ATerminalRequest;
import ru.semperante.tinkoff.models.terminals.Order;
import ru.semperante.tinkoff.models.terminals.response.ATerminalResponse;
import ru.semperante.tinkoff.models.terminals.response.InitResponse;
import ru.semperante.tinkoff.models.terminals.Receipt;
import ru.semperante.tinkoff.models.terminals.Shop;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;
/**
 * @author SemperAnte
 * @version 1.0
 * Инициализация платежа
 */
public final class InitRequest extends ATerminalRequest {
   private long Amount;
   private String OrderId;
   private String SuccessURL;
   private String FailURL;
   private String NotificationURL;
   private String Description;
   private String CustomerKey;
   private String Recurrent;
   private String PayType;
   private String Language;
   @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
   private Timestamp RedirectDueDate;
   private Map<String, String> DATA;
   private Receipt Receipt;
   private List<Shop> Shops;
   private String Descriptor;

   public InitRequest() {
   }



   public long getAmount() {
      return Amount;
   }

   public InitRequest setAmount(long amount) {
      Amount = amount;
      return this;
   }

   public String getOrderId() {
      return OrderId;
   }

   public InitRequest setOrderId(String orderId) {
      OrderId = orderId;
      return this;
   }

   public String getSuccessURL() {
      return SuccessURL;
   }

   public InitRequest setSuccessURL(String successURL) {
      SuccessURL = successURL;
      return this;
   }

   public String getFailURL() {
      return FailURL;
   }

   public InitRequest setFailURL(String failURL) {
      FailURL = failURL;
      return this;
   }

   public String getNotificationURL() {
      return NotificationURL;
   }

   public InitRequest setNotificationURL(String notificationURL) {
      NotificationURL = notificationURL;
      return this;
   }

   public String getDescription() {
      return Description;
   }

   public InitRequest setDescription(String description) {
      Description = description;
      return this;
   }

   public String getCustomerKey() {
      return CustomerKey;
   }

   public InitRequest setCustomerKey(String customerKey) {
      CustomerKey = customerKey;
      return this;
   }

   public String getRecurrent() {
      return Recurrent;
   }

   public InitRequest setRecurrent(String recurrent) {
      Recurrent = recurrent;
      return this;
   }

   public String getPayType() {
      return PayType;
   }

   public InitRequest setPayType(String payType) {
      PayType = payType;
      return this;
   }

   public String getLanguage() {
      return Language;
   }

   public InitRequest setLanguage(String language) {
      Language = language;
      return this;
   }

   public Timestamp getRedirectDueDate() {
      return RedirectDueDate;
   }

   public InitRequest setRedirectDueDate(Timestamp redirectDueDate) {
      RedirectDueDate = redirectDueDate;
      return this;
   }

   public Map<String, String> getDATA() {
      return DATA;
   }

   public InitRequest setDATA(Map<String, String> DATA) {
      this.DATA = DATA;
      return this;
   }

   public ru.semperante.tinkoff.models.terminals.Receipt getReceipt() {
      return Receipt;
   }

   public InitRequest setReceipt(ru.semperante.tinkoff.models.terminals.Receipt receipt) {
      Receipt = receipt;
      return this;
   }

   public List<Shop> getShops() {
      return Shops;
   }

   public InitRequest setShops(List<Shop> shops) {
      Shops = shops;
      return this;
   }

   public String getDescriptor() {
      return Descriptor;
   }

   public InitRequest setDescriptor(String descriptor) {
      Descriptor = descriptor;
      return this;
   }

   public static InitRequest buildFromOrder(Order order)
   {
      return new InitRequest().setAmount(order.getAmount()).setOrderId(String.valueOf(order.getId()));
   }

   @Override
   public Class<? extends ATerminalResponse> responseType() {
      return InitResponse.class;
   }

   @Override
   public String routing() {
      return "Init";
   }

   public enum PayType {
      O, I
   }
}
