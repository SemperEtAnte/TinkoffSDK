package ru.semperante.tinkoff.models.terminals;

import java.math.BigInteger;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public class Order {
   private Long id;
   private Long amount;

   private BigInteger tinkoffId;

   public Order(Long id, Long amount) {
      this.id = id;
      this.amount = amount;
   }

   public Order() {
   }

   public Long getId() {
      return id;
   }

   public void setId(Long id) {
      this.id = id;
   }

   public Long getAmount() {
      return amount;
   }

   public void setAmount(Long amount) {
      this.amount = amount;
   }

   public BigInteger getTinkoffId() {
      return tinkoffId;
   }

   public void setTinkoffId(BigInteger tinkoffId) {
      this.tinkoffId = tinkoffId;
   }
}
