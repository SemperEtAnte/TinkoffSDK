package ru.semperante.tinkoff.models.terminals;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public final class Payments {
   private Long Cash;
   private Long Electronic;
   private Long AdvancePayment;
   private Long Credit;
   private Long Provision;

   public Payments() {
   }

   public Payments(Long electronic) {
      this.Electronic = electronic;
   }

   public Long getCash() {
      return Cash;
   }

   public Long getElectronic() {
      return Electronic;
   }

   public Long getAdvancePayment() {
      return AdvancePayment;
   }

   public Long getCredit() {
      return Credit;
   }

   public Long getProvision() {
      return Provision;
   }

   public Payments setCash(Long cash) {
      this.Cash = cash;
      return this;
   }

   public Payments setElectronic(Long electronic) {
      this.Electronic = electronic;
      return this;
   }

   public Payments setAdvancePayment(Long advancePayment) {
      this.AdvancePayment = advancePayment;
      return this;
   }

   public Payments setCredit(Long credit) {
      this.Credit = credit;
      return this;
   }

   public Payments setProvision(Long provision) {
      this.Provision = provision;
      return this;
   }
}
