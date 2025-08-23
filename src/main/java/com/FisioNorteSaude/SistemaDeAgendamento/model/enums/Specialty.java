package com.FisioNorteSaude.SistemaDeAgendamento.model.enums;

public enum Specialty {
    PSYCHOLOGIST(1),
    PHYSIOTHERAPIST(2);

    private int code;

    private Specialty(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static Specialty valueOf(int code) {
        for (Specialty value : Specialty.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Specialty Code");
    }
}