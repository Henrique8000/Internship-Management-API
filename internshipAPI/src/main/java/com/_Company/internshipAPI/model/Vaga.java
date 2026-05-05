package com._Company.internshipAPI.model;

import java.time.LocalDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class Vaga {
	
	@Id
	@GeneratedValue
	private Long id;
	private String titulo;
	private String descricao;
	private LocalDate dataPublicacao;
	private StatusVaga status;
	private Long idEmpresa;
	
	
}
