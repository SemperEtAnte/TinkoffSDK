package ru.semperante.tinkoff.models.terminals;
/**
 * @author SemperAnte
 * @version 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public class Shop {
   public String ShopCode;
   public Long Amount;
   public String Name;
   public String Fee;

   public String getShopCode() {
      return ShopCode;
   }

   public Shop setShopCode(String shopCode) {
      ShopCode = shopCode;
      return this;
   }

   public Long getAmount() {
      return Amount;
   }

   public Shop setAmount(Long amount) {
      Amount = amount;
      return this;
   }

   public String getName() {
      return Name;
   }

   public Shop setName(String name) {
      Name = name;
      return this;
   }

   public String getFee() {
      return Fee;
   }

   public Shop setFee(String fee) {
      Fee = fee;
      return this;
   }
}
