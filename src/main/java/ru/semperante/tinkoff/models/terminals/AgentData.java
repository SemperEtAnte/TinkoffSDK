package ru.semperante.tinkoff.models.terminals;

import java.util.List;

/**
 * @author SemperAnte
 * @version 1.0
 * @since 1.0
 * Описание полей <a href="https://www.tinkoff.ru/kassa/dev/payments/">тут</a>
 */
public final class AgentData {


   private AgentSign AgentSign;
   private String OperationName;
   private List<String> Phones;
   private List<String> ReceiverPhones;
   private List<String> TransferPhones;
   private String OperatorName;
   private String OperatorAddress;
   private String OperatorInn;

   public AgentData.AgentSign getAgentSign() {
      return AgentSign;
   }

   public AgentData setAgentSign(AgentData.AgentSign agentSign) {
      AgentSign = agentSign;
      return this;
   }

   public String getOperationName() {
      return OperationName;
   }

   public AgentData setOperationName(String operationName) {
      OperationName = operationName;
      return this;
   }

   public List<String> getPhones() {
      return Phones;
   }

   public AgentData setPhones(List<String> phones) {
      Phones = phones;
      return this;
   }

   public AgentData setPhones(String... phones) {
      return setPhones(List.of(phones));
   }

   public List<String> getReceiverPhones() {
      return ReceiverPhones;
   }

   public AgentData setReceiverPhones(List<String> receiverPhones) {
      ReceiverPhones = receiverPhones;
      return this;
   }

   public AgentData setReceiverPhones(String... receiverPhones) {
      return setReceiverPhones(List.of(receiverPhones));
   }

   public List<String> getTransferPhones() {
      return TransferPhones;
   }

   public AgentData setTransferPhones(List<String> transferPhones) {
      TransferPhones = transferPhones;
      return this;
   }

   public AgentData setTransferPhones(String... transferPhones) {
      return setTransferPhones(List.of(transferPhones));
   }

   public String getOperatorName() {
      return OperatorName;
   }

   public AgentData setOperatorName(String operatorName) {
      OperatorName = operatorName;
      return this;
   }

   public String getOperatorAddress() {
      return OperatorAddress;
   }

   public AgentData setOperatorAddress(String operatorAddress) {
      OperatorAddress = operatorAddress;
      return this;
   }

   public String getOperatorInn() {
      return OperatorInn;
   }

   public AgentData setOperatorInn(String operatorInn) {
      OperatorInn = operatorInn;
      return this;
   }

   public enum AgentSign {
      bank_paying_agent,
      bank_paying_subagent,
      paying_agent,
      paying_subagent,
      attorney,
      commission_agent,
      another
   }
}
