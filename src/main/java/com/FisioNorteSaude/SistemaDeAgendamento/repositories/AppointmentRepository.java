package com.FisioNorteSaude.SistemaDeAgendamento.repositories;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Appointment;
import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findByProfessionalAndDateTimeBetweenOrderByDateTimeAsc(
            Professional professional,
            LocalDateTime start,
            LocalDateTime end
    );
}
