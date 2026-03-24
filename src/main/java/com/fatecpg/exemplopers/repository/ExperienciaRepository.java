package com.fatecpg.exemplopers.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fatecpg.exemplopers.model.ExperienciaProfissional;

@Repository
public interface ExperienciaRepository extends JpaRepository<ExperienciaProfissional, Long> {
}
