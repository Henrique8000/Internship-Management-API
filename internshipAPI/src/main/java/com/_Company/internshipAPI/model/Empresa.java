package com._Company.internshipAPI.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Empresa {
	
	@Id
	private Long id;
	private String nome;
	private String cnpj;
	private String emailContato;
	
}
