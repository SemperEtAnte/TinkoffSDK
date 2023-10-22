package ru.semperante.tinkoff.models.business;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 * Ознакомиться с описанием можно <a href="https://developer.tinkoff.ru/docs/api/post-api-v-1-invoice-send">тут</a>
 */
public class Item {
   @NotBlank
   private String name;
   @Positive
   private float price;
   @NotBlank
   private String unit;
   @NotNull
   private Vat vat;
   @Positive
   private int amount;

   public Item() {
   }

   public Item(String name, float price, String unit, Vat vat, int amount) {
      this.name = name;
      this.price = price;
      this.unit = unit;
      this.vat = vat;
      this.amount = amount;
   }

   public String getName() {
      return name;
   }

   public Item setName(String name) {
      this.name = name;
      return this;
   }

   public float getPrice() {
      return price;
   }

   public Item setPrice(float price) {
      this.price = price;
      return this;
   }

   public String getUnit() {
      return unit;
   }

   public Item setUnit(String unit) {
      this.unit = unit;
      return this;
   }

   public Vat getVat() {
      return vat;
   }

   public Item setVat(Vat vat) {
      this.vat = vat;
      return this;
   }

   public int getAmount() {
      return amount;
   }

   public Item setAmount(int amount) {
      this.amount = amount;
      return this;
   }

   public enum Vat {

      @JsonProperty("None")
      none,
      @JsonProperty("0")
      val_0,
      @JsonProperty("10")
      val_10,
      @JsonProperty("18")
      val_18,
      @JsonProperty("20")
      val_20
   }
}
