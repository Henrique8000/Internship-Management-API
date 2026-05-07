package com._Company.internshipAPI.model.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name="estudante")
@NoArgsConstructor
@AllArgsConstructor
public class Estudante {
	
	@Id
	@GeneratedValue
	@NotNull
	@Getter
	private Long id;
	
	@NotBlank
	@Size(max = 150)
	private String nome;
	
	@NotBlank
	@Pattern(regexp = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,}$", message = "Email inválido")
	private String email;
	
	@NotNull(message = "Data de nascimento é obrigatória")
	@JsonFormat(pattern = "yyyy-MM-dd")
	private LocalDate dataNascimento;
	
	private Long idCurso;
	private String faculdade;
	private Integer anoIngresso;
	private Integer anoFormatura;
	
	//private List<AreaInteresse> areasDeInteresse;
	
}
