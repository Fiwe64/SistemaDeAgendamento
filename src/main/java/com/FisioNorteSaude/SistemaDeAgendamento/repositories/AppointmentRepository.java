package com.FisioNorteSaude.SistemaDeAgendamento.repositories;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Appointment;
import com.FisioNorteSaude.SistemaDeAgendamento.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {
}
