package com._Company.internshipAPI.model.dao;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com._Company.internshipAPI.model.entities.Empresa;

public interface EmpresaDAO extends CrudRepository<Empresa, Long>{
	public List<Empresa> findAll();
	
}
