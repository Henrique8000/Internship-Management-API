package com._Company.internshipAPI.model.entities;

import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Table(name="area")
@NoArgsConstructor
@AllArgsConstructor

public class AreaInteresse {
	
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    @NotBlank
    @Size(max = 120)
    private String nome;

}
