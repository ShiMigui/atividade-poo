package com.fatecpg.exemplopers.service;

import com.fatecpg.exemplopers.model.*;
import com.fatecpg.exemplopers.repository.*;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class ExperienciaService {

  private final ExperienciaRepository repo;

  public ExperienciaService(ExperienciaRepository repo) {
    this.repo = repo;
  }

  public ExperienciaProfissional salvarExperienciaProfissional(ExperienciaProfissional exp) {
    return repo.save(exp);
  }

  public List<ExperienciaProfissional> getAllExperienciaProfissionals() {
    return repo.findAll();
  }

  public Optional<ExperienciaProfissional> updateExperienciaProfissional(
      Long id, ExperienciaProfissional newData) {
    return repo.findById(id)
        .map(
            exp -> {
              exp.setDescricao(newData.getDescricao());
              exp.setCargaHoraria(newData.getCargaHoraria());
              exp.setFuncionario(newData.getFuncionario());
              return repo.save(exp);
            });
  }

  public boolean deleteExperienciaProfissional(Long id) {
    if (repo.existsById(id)) {
      repo.deleteById(id);
      return true;
    }
    return false;
  }
}
