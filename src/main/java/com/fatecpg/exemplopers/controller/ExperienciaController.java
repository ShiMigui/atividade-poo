package com.fatecpg.exemplopers.controller;

import com.fatecpg.exemplopers.model.ExperienciaProfissional;
import com.fatecpg.exemplopers.service.ExperienciaService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/meusite")
public class ExperienciaController {

  private final ExperienciaService experienciaService;

  public ExperienciaController(ExperienciaService experienciaService) {
    this.experienciaService = experienciaService;
  }

  @PostMapping("/experiencias")
  @ResponseStatus(org.springframework.http.HttpStatus.CREATED) // status 201 = Created
  public ResponseEntity<ExperienciaProfissional> postMethodName( @RequestBody ExperienciaProfissional experiencia) {
    ExperienciaProfissional experienciaCriada = experienciaService.salvarExperienciaProfissional(experiencia);
    return ResponseEntity.ok(experienciaCriada);
  }

  @GetMapping("/experiencias")
  public ResponseEntity<List<ExperienciaProfissional>> allExperienciaProfissionals() {
    List<ExperienciaProfissional> experiencias =
        experienciaService.getAllExperienciaProfissionals();
    return ResponseEntity.ok(experiencias);
  }

  @PutMapping("/experiencias/{id}")
  public ResponseEntity<ExperienciaProfissional> updateUser(
      @PathVariable Long id, @RequestBody ExperienciaProfissional experiencia) {
    return experienciaService
        .updateExperienciaProfissional(id, experiencia)
        .map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
  }

  @DeleteMapping("/experiencias/{id}")
  public ResponseEntity<Void> deleteExperienciaProfissional(@PathVariable Long id) {
    boolean deleted = experienciaService.deleteExperienciaProfissional(id);
    if (deleted) {
      return ResponseEntity.noContent().build(); // 204 No Content
    } else {
      return ResponseEntity.notFound().build(); // 404 Not Found
    }
  }
}
