package ru.semperante.tinkoff.models.terminals.receipt;

import java.util.List;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public class SupplierInfo {

   private List<String> Phones;
   private String Name;
   private String Inn;

   public List<String> getPhones() {
      return Phones;
   }

   public SupplierInfo setPhones(List<String> phones) {
      Phones = phones;
      return this;
   }

   public SupplierInfo setPhones(String... phones) {
      return setPhones(List.of(phones));
   }

   public String getName() {
      return Name;
   }

   public SupplierInfo setName(String name) {
      Name = name;
      return this;
   }

   public String getInn() {
      return Inn;
   }

   public SupplierInfo setInn(String inn) {
      Inn = inn;
      return this;
   }
}
