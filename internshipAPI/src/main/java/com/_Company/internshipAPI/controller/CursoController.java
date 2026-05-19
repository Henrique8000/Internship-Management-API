package com._Company.internshipAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com._Company.internshipAPI.model.entities.Curso;
import com._Company.internshipAPI.service.CursoService;

import jakarta.validation.Valid;

@RestController
@RequestMapping({"/api/cursos", "/internship/api/cursos"})
public class CursoController {

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public List<Curso> getAll() {
        return cursoService.getAllCursos();
    }

    @GetMapping("/{id}")
    public Curso getById(@PathVariable Long id) {
        return cursoService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Curso cadastrarCurso(@Valid @RequestBody Curso curso) {
        return cursoService.create(curso);
    }

    @PutMapping("/{id}")
    public Curso atualizarCurso(@PathVariable Long id, @Valid @RequestBody Curso newCurso) {
        return cursoService.updateCurso(id, newCurso);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarCurso(@PathVariable Long id) {
        cursoService.deleteById(id);
    }
}