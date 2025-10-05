package com.FisioNorteSaude.SistemaDeAgendamento.repositories;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Appointment;
import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    Optional<Professional> findByCpf(String cpf);


}
