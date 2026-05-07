package com._Company.internshipAPI.model.entities;

import java.time.LocalDate;

import com._Company.internshipAPI.model.entities.enums.StatusVaga;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@Entity
@Table(name="vaga")
@NoArgsConstructor
@AllArgsConstructor
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
