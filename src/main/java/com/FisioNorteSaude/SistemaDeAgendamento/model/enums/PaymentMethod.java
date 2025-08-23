package com.FisioNorteSaude.SistemaDeAgendamento.model.enums;

public enum PaymentMethod {
    PIX(1),
    DEBIT(2),
    CREDIT(3),
    HEALTH_INSURANCE(4);

    private int code;

    private PaymentMethod(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static PaymentMethod valueOf(int code) {
        for (PaymentMethod value : PaymentMethod.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Payment Method Code");
    }
}