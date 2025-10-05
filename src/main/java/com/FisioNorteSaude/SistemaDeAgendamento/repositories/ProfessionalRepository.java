package com.FisioNorteSaude.SistemaDeAgendamento.repositories;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProfessionalRepository extends JpaRepository<Professional, Long> {
    Optional<Professional> findByCpf(String cpf);
}
