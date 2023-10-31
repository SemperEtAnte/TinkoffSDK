package ru.semperante.tinkoff;

import org.jboss.logging.Logger;
import org.junit.jupiter.api.*;
import ru.semperante.tinkoff.models.terminals.Order;
import ru.semperante.tinkoff.models.terminals.request.GetStateRequest;
import ru.semperante.tinkoff.models.terminals.request.InitRequest;
import ru.semperante.tinkoff.models.terminals.response.GetStateResponse;
import ru.semperante.tinkoff.models.terminals.response.InitResponse;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Properties;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;


@TestClassOrder(value = ClassOrderer.OrderAnnotation.class)
@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
public class MainTest {
   private static final Logger LOGGER = Logger.getLogger(MainTest.class);
   private static final Random RAND = new SecureRandom();
   private final TinkoffTerminalApi api;
   private final BigInteger testPaymentId;

   public MainTest() {
      Properties pr = new Properties();
      String terminalId;
      String password;
      BigInteger paymentId;

      try (InputStream fis = MainTest.class.getResourceAsStream("/keys.properties")) {
         pr.load(fis);
         password = pr.getProperty("password", null);
         paymentId = BigInteger.valueOf(Long.parseLong(pr.getProperty("paymentId")));
         terminalId = pr.getProperty("terminalId", null);
      }
      catch (IOException e) {
         terminalId = System.getenv("terminalId");
         password = System.getenv("password");
         String envPayment = System.getenv("paymentId");
         if (envPayment == null || envPayment.isBlank()) {
            paymentId = null;
         } else {
            paymentId = new BigInteger(envPayment);
         }
      }
      if (terminalId == null) {
         throw new RuntimeException("TerminalId is not loaded!");
      }
      if (password == null) {
         throw new RuntimeException("Password is not loaded!");
      }
      this.testPaymentId = paymentId;
      LOGGER.infof("Loaded props:\nPassword: %s\nTerminalId: %s", password, terminalId);
      this.api = new TinkoffTerminalApi(terminalId, password);
   }


   @Test
   void initTest() {
      try {
         Order to = new Order(RAND.nextLong(), 123L);
         InitResponse initResponse = api.sendRequest(InitRequest.buildFromOrder(to)
                 .setSuccessURL("http://127.0.0.1/success")
                 .setFailURL("http://127.0.0.1/fail")
                 .setDescription("Тестовый платеж"));
         to.setTinkoffId(initResponse.getPaymentId());
         assertNotNull(to.getTinkoffId(), "Tinkoff Id should not be null");

         GetStateResponse checkStatusResponse = api.sendRequest(GetStateRequest.buildFromOrder(to));
         LOGGER.infof("Check status response: %s", checkStatusResponse);
      }
      catch (IOException | InterruptedException e) {
         fail(e);
      }
   }

   @Test
   void checkStatus() {
      if (testPaymentId == null) {
         return;
      }

      try {
         GetStateResponse checkStatusResponse = api.sendRequest(new GetStateRequest().setPaymentId(testPaymentId));
         LOGGER.infof("Check status response: %s", checkStatusResponse);
      }
      catch (IOException | InterruptedException e) {
         fail(e);
      }
   }
}
