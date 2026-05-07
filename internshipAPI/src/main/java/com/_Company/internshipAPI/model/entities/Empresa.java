package com._Company.internshipAPI.model.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="empresa")
public class Empresa {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@NotBlank
	@Size(max = 150)
	private String nome;
	
	@NotBlank
	@Column(unique = true)
	private String cnpj;
	
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Email inválido")
	private String emailContato;

	public Empresa() {
	}
	
	public Empresa(Long id, String nome, String cnpj, String emailContato) {
		this.id = id;
		this.nome = nome;
		this.cnpj = cnpj;
		this.emailContato = emailContato;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getEmailContato() {
		return emailContato;
	}

	public void setEmailContato(String emailContato) {
		this.emailContato = emailContato;
	}

	public Long getId() {
		return id;
	}
}
