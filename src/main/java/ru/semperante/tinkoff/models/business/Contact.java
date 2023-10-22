package ru.semperante.tinkoff.models.business;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 * Ознакомиться с описанием можно <a href="https://developer.tinkoff.ru/docs/api/post-api-v-1-invoice-send">тут</a>
 */
public class Contact {
   @Email
   @NotNull
   private String email;

   public Contact() {
   }

   public Contact(String email) {
      this.email = email;
   }

   public String getEmail() {
      return email;
   }

   public Contact setEmail(String email) {
      this.email = email;
      return this;
   }
}
