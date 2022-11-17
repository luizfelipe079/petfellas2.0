package com.gft.desafio.veterinario.repositories;

import com.gft.desafio.veterinario.entities.Veterinario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VeterinarioRepository extends JpaRepository<Veterinario, Long> {
}
