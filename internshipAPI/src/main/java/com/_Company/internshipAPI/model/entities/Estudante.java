package com._Company.internshipAPI.model.entities;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "estudante")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Estudante {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String nome;

    @NotBlank
    @Email
    @Column(nullable = false, unique = true)
    private String email;

    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Column(nullable = false)
    private LocalDate dataNascimento;

    @NotNull
    @Column(nullable = false)
    private Long idCurso;

    @NotBlank
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String faculdade;

    @NotNull
    @Column(nullable = false)
    private Integer anoIngresso;

    @NotNull
    @Column(nullable = false)
    private Integer anoFormatura;

    @ManyToMany
    @JoinTable(
          name = "estudante_area_interesse",
          joinColumns = @JoinColumn(name = "estudante_id"),
          inverseJoinColumns = @JoinColumn(name = "area_interesse_id")
    )
    private Set<AreaInteresse> areasInteresse = new HashSet<>();
}

Entidade Empresa
package com._Company.internshipAPI.model.entities;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.*;

@Entity
@Table(name = "empresa")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class Empresa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Include
    private Long id;

    @NotBlank
    @Size(max = 150)
    @Column(nullable = false, length = 150)
    private String nome;

    @NotBlank
    @Column(nullable = false, unique = true)
    private String cnpj;

    @NotBlank
    @Email
    @Column(nullable = false)
    private String emailContato;
}
