package com._Company.internshipAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import com._Company.internshipAPI.model.entities.AreaInteresse;
import com._Company.internshipAPI.service.AreaInteresseService;

import jakarta.validation.Valid;

@RestController
@RequestMapping({"/api/areas-interesse", "/internship/api/areas-interesse"})
public class AreaInteresseController {

    @Autowired
    private AreaInteresseService areaInteresseService;

    @GetMapping
    public List<AreaInteresse> getAll() {
        return areaInteresseService.getAllAreasInteresse();
    }

    @GetMapping("/{id}")
    public AreaInteresse getById(@PathVariable Long id) {
        return areaInteresseService.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public AreaInteresse cadastrarAreaInteresse(@Valid @RequestBody AreaInteresse areaInteresse) {
        return areaInteresseService.create(areaInteresse);
    }

    @PutMapping("/{id}")
    public AreaInteresse atualizarAreaInteresse(@PathVariable Long id, @Valid @RequestBody AreaInteresse newAreaInteresse) {
        return areaInteresseService.updateAreaInteresse(id, newAreaInteresse);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deletarAreaInteresse(@PathVariable Long id) {
        areaInteresseService.deleteById(id);
    }
}