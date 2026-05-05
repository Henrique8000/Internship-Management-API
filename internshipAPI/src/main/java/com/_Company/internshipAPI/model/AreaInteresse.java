package com._Company.internshipAPI.model;
import lombok.*;
import jakarta.persistence.*;
import jakarta.validation.constraints.*;

@Entity
@Getter
@NoArgsConstructor

public class AreaInteresse {
    @Id
    @GeneratedValue
    private Long id;

    @Setter
    @NotBlank
    @Size(max = 120)
    private String nome;

}
