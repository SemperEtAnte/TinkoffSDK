package ru.semperante.tinkoff.models.business;

import jakarta.validation.constraints.NotBlank;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 * Ознакомиться с описанием можно <a href="https://developer.tinkoff.ru/docs/api/post-api-v-1-invoice-send">тут</a>
 */
public class Payer {
   @NotBlank
   private String name;
   @NotBlank
   private String inn;
   @NotBlank
   private String kpp;

   public String getName() {
      return name;
   }

   public Payer setName(String name) {
      this.name = name;
      return this;
   }

   public String getInn() {
      return inn;
   }

   public Payer setInn(String inn) {
      this.inn = inn;
      return this;
   }

   public String getKpp() {
      return kpp;
   }

   public Payer setKpp(String kpp) {
      this.kpp = kpp;
      return this;
   }
}
