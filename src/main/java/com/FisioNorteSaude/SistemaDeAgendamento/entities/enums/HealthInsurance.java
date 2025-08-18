package com.FisioNorteSaude.SistemaDeAgendamento.entities.enums;

public enum HealthInsurance {
    AMIL(1),
    BRADESCO_SAUDE(2),
    CAIXA_SEGURADORA_SAUDE(3),
    CENTRAL_NACIONAL_UNIMED(4),
    GOLDEN_CROSS(5),
    INTERMEDICA_NOTREDAME(6),
    MEDIAL_SAUDE(7),
    OMINT(8),
    PORTO_SEGURO_SAUDE(9),
    PREVENT_SENIOR(10),
    SULAMERICA(11),
    UNIMED_BH(12),
    UNIMED_RIO(13),
    UNIMED_RECIFE(14),
    UNIMED_CURITIBA(15),
    UNIMED_CAMPINAS(16),
    UNIMED_VITORIA(17),
    UNIMED_PORTO_ALEGRE(18),
    UNIMED_BELEM(19),
    HAPVIDA(20),
    POSTAL_SAUDE(21);

    private int code;

    private HealthInsurance(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static HealthInsurance valueOf(int code) {
        for (HealthInsurance value : HealthInsurance.values()) {
            if (value.getCode() == code) {
                return value;
            }
        }
        throw new IllegalArgumentException("Invalid Health Insurance Code");
    }
}