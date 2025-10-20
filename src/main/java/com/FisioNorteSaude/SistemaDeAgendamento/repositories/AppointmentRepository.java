package com.FisioNorteSaude.SistemaDeAgendamento.repositories;

import com.FisioNorteSaude.SistemaDeAgendamento.model.Appointment;
import com.FisioNorteSaude.SistemaDeAgendamento.model.Professional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.List;

public interface AppointmentRepository extends JpaRepository<Appointment,Long> {

    List<Appointment> findByProfessionalAndDateTimeBetweenOrderByDateTimeAsc(
            Professional professional,
            LocalDateTime start,
            LocalDateTime end
    );

    // NOVO MÉTODO: Retorna apenas as LocalTime ocupadas de um Professional em um dia.

    @Query("SELECT FUNCTION('TIME', a.dateTime) FROM Appointment a " +
            "WHERE a.professional = :professional " +
            "AND FUNCTION('DATE', a.dateTime) = :date " +
            "AND a.finalizado = false") // Filtra apenas agendamentos não finalizados
    List<LocalTime> findOccupiedTimesByProfessionalAndDate(
            @Param("professional") Professional professional,
            @Param("date") LocalDate date
    );


    /**
     * Verifica se o profissional possui QUALQUER agendamento ATIVO em uma data específica.
     * Retorna TRUE se houver agendamentos não finalizados na data, FALSE caso contrário.
     *
     *
     *
    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Appointment a " +
            "WHERE a.professional = :professional " +
            "AND FUNCTION('DATE', a.dateTime) = :date " +
            "AND a.finalizado = false")*/



    /**
     * Verifica se o profissional possui QUALQUER agendamento ATIVO em uma data específica.
     * Corrigido para ser compatível com o banco H2 (usando CAST).
     */


    @Query("SELECT CASE WHEN COUNT(a) > 0 THEN TRUE ELSE FALSE END FROM Appointment a " +
            "WHERE a.professional = :professional " +
            "AND CAST(a.dateTime AS date) = :date " + // <-- CORREÇÃO APLICADA AQUI
            "AND a.finalizado = false")
    boolean existsActiveAppointmentOnDate(
            @Param("professional") Professional professional,
            @Param("date") LocalDate date
    );

    boolean existsActiveAppointmentOnDateTime(
            @Param("professional") Professional professional,
            @Param("dateTime") LocalDateTime dateTime
    );
}
