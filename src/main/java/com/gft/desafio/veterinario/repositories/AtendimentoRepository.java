package com.gft.desafio.veterinario.repositories;

import com.gft.desafio.veterinario.entities.Atendimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AtendimentoRepository extends JpaRepository<Atendimento, Long> {

    @Query("SELECT a FROM Atendimento a " +
            "JOIN a.cliente c " +
            "WHERE lower(c.email) like lower(:email)")
    List<Atendimento> findByClienteByemail(String email);
}
