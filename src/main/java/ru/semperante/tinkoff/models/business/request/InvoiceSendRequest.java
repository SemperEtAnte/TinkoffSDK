package ru.semperante.tinkoff.models.business.request;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import ru.semperante.tinkoff.ABusinessRequest;
import ru.semperante.tinkoff.models.business.Contact;
import ru.semperante.tinkoff.models.business.Item;
import ru.semperante.tinkoff.models.business.Payer;
import ru.semperante.tinkoff.models.business.response.ABusinessResponse;
import ru.semperante.tinkoff.models.business.response.InvoiceSendResponse;

import java.util.Date;
import java.util.List;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.1
 * Запрос "выставить счет"
 * <p>
 * Ознакомиться с описанием можно <a href="https://business.tinkoff.ru/openapi/api/v1/invoice/send">тут</a>
 */
public class InvoiceSendRequest extends ABusinessRequest {
   @Pattern(regexp = "^\\d{1,15}$")
   @NotNull
   private String invoiceNumber;
   private Date dueDate;
   private Date invoiceDAte;
   @Pattern(regexp = "^(\\d{20}|\\d{22})$")
   private String accountNumber;
   @NotNull
   @Valid
   private Payer payer;
   @NotEmpty
   @Valid
   private List<@NotNull Item> items;
   @Valid
   private List<@NotNull Contact> contacts;
   @Pattern(regexp = "^((\\+7)([0-9]){10})$")
   private String contactPhone;
   @Size(min = 1, max = 511)
   @NotNull
   private String comment;


   public String getInvoiceNumber() {
      return invoiceNumber;
   }

   public InvoiceSendRequest setInvoiceNumber(String invoiceNumber) {
      this.invoiceNumber = invoiceNumber;
      return this;
   }

   public Date getDueDate() {
      return dueDate;
   }

   public InvoiceSendRequest setDueDate(Date dueDate) {
      this.dueDate = dueDate;
      return this;
   }

   public Date getInvoiceDAte() {
      return invoiceDAte;
   }

   public InvoiceSendRequest setInvoiceDAte(Date invoiceDAte) {
      this.invoiceDAte = invoiceDAte;
      return this;
   }

   public String getAccountNumber() {
      return accountNumber;
   }

   public InvoiceSendRequest setAccountNumber(String accountNumber) {
      this.accountNumber = accountNumber;
      return this;
   }

   public Payer getPayer() {
      return payer;
   }

   public InvoiceSendRequest setPayer(Payer payer) {
      this.payer = payer;
      return this;
   }

   public List<Item> getItems() {
      return items;
   }

   public InvoiceSendRequest setItems(List<Item> items) {
      this.items = items;
      return this;
   }

   public List<Contact> getContacts() {
      return contacts;
   }

   public InvoiceSendRequest setContacts(List<Contact> contacts) {
      this.contacts = contacts;
      return this;
   }

   public String getContactPhone() {
      return contactPhone;
   }

   public InvoiceSendRequest setContactPhone(String contactPhone) {
      this.contactPhone = contactPhone;
      return this;
   }

   public String getComment() {
      return comment;
   }

   public InvoiceSendRequest setComment(String comment) {
      this.comment = comment;
      return this;
   }

   @Override
   public Class<? extends ABusinessResponse> responseType() {
      return InvoiceSendResponse.class;
   }

   @Override
   public String routing() {
      return "invoice/send";
   }

   @Override
   public String method() {
      return "POST";
   }
}
