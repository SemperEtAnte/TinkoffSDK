package ru.semperante.tinkoff.models.terminals;

import java.util.Map;

public record NotificationBody(
        String TerminalKey,
        String Amount,
        String OrderId,
        String Success,
        String Status,
        String PaymentId,
        String ErrorCode,
        String PaymentURL,
        String Message,
        String Details,
        String RebillId,
        String CardId,
        String Pan,
        String ExpDate,
        String Token,
        Map<String, String> DATA
) {
}
