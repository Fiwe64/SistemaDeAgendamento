package com.FisioNorteSaude.SistemaDeAgendamento.repositories;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    Optional<Professional> findByCpf(String cpf);

    List<Appointment> findByProfessionalAndDateTimeBetweenOrderByDateTimeAsc(
            Professional professional,
            LocalDateTime start,
            LocalDateTime end
    );
}
