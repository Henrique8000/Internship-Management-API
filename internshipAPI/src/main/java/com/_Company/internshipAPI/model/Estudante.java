package com._Company.internshipAPI.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Estudante {
	
	@Id
	@GeneratedValue
	private Long id;
	
	private String nome;
	private String email;
	private LocalDate dataNascimento;
	private Long idCurso;
	private String faculdade;
	private Integer anoIngresso;
	private Integer anoFormatura;
	
}
