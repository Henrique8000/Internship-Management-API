package com._Company.internshipAPI.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com._Company.internshipAPI.model.entities.Empresa;
import com._Company.internshipAPI.service.EmpresaService;

@RestController
@RequestMapping("/internship/api/empresas")
public class EmpresaController {
	
	@Autowired
	private EmpresaService empresaService;
	
	@GetMapping("/all")
	public List<Empresa> getAll() {
		return this.empresaService.getAllEmpresas();
	}
	
	@GetMapping("/{id}")
	public Empresa getByName(@PathVariable Long id) {
		return this.empresaService.getById(id);
	}
	
	@PostMapping("/cadastrar")
	public void cadastrarEmpresa(@RequestBody Empresa empresa) {
		this.empresaService.create(empresa);
	}
	
}
