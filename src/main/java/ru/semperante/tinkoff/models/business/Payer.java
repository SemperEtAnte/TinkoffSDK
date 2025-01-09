package ru.semperante.tinkoff.models.business;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 * Ознакомиться с описанием можно <a href="https://developer.tinkoff.ru/docs/api/post-api-v-1-invoice-send">тут</a>
 */
public class Payer {
   @NotBlank
   @Size(max = 512)
   private String name;
   @Pattern(regexp = "^(\\d{12}|\\d{10})$")
   private String inn;
   @Pattern(regexp = "^(\\d{9})$")
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
