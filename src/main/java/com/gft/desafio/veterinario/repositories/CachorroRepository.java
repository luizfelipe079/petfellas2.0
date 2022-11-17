package com.gft.desafio.veterinario.repositories;

import com.gft.desafio.veterinario.entities.Cachorro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CachorroRepository extends JpaRepository<Cachorro, Long> {
}
