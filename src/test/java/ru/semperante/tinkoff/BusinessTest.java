package ru.semperante.tinkoff;

import com.fasterxml.jackson.databind.node.ObjectNode;
import org.jboss.logging.Logger;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import ru.semperante.tinkoff.models.business.Item;
import ru.semperante.tinkoff.models.business.Payer;
import ru.semperante.tinkoff.models.business.request.InvoiceSendRequest;

import java.util.List;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class BusinessTest {
   private static final Logger LOGGER = Logger.getLogger(BusinessTest.class);

   @Test
   @Order(1)
   public void buildStringFromDto() {
      InvoiceSendRequest request = new InvoiceSendRequest().setAccountNumber("123")
              .setComment("commd")
              .setItems(List.of(new Item().setName("hello1")))
              .setPayer(new Payer().setName("name").setInn("123").setKpp("123"))
              .setContactPhone("phone");
      String result = TinkoffBusinessApi.objectToParams(request);
      LOGGER.infof("Test result: %s", result);
   }
}
