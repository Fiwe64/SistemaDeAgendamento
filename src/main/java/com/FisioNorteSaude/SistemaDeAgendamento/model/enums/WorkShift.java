package com.FisioNorteSaude.SistemaDeAgendamento.model.enums;

import lombok.Getter;

import java.time.LocalTime;


@Getter
public enum WorkShift {

    MORNING(LocalTime.of(9,0),LocalTime.of(12,0)),
    AFTERNOON(LocalTime.of(13,0),LocalTime.of(18,0));

    private final LocalTime startTime;
    private final LocalTime endTime;

    WorkShift(LocalTime startTime, LocalTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}
