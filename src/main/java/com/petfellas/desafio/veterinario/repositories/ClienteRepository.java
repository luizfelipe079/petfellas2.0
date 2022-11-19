package com.petfellas.desafio.veterinario.repositories;

import com.petfellas.desafio.veterinario.entities.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
