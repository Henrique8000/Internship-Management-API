package com._Company.internshipAPI.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import com._Company.internshipAPI.model.dao.EmpresaDAO;
import com._Company.internshipAPI.model.entities.Empresa;

@Service
public class EmpresaService {
	@Autowired
	private EmpresaDAO empresaDAO;
	
    public void create(Empresa v){
        this.empresaDAO.save(v);
    }
    
    public List<Empresa> getAllEmpresas(){
        return this.empresaDAO.findAll();
    }
    
    public Empresa getById(Long id){
        return this.empresaDAO.findById(id)
        		.orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Empresa com o ID " + id + "não encontrado:"));
    }
    
    public void deleteById(Long id) {
    	this.empresaDAO.deleteById(id);
    }
    
    public void updateEmpresa(Long id, Empresa newEmpresa) {
    	Empresa e = getById(id);
  
    	e.setNome(newEmpresa.getNome());
    	e.setCnpj(newEmpresa.getCnpj());
    	e.setEmailContato(newEmpresa.getEmailContato());
    	
    	empresaDAO.save(e);
    	
    }
}
