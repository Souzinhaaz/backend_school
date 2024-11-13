package com.example.project_school.dto.alunos;

import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateAlunoDTO(
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotNull
        Long id_turma,
        @NotBlank
        String responsibleTelephone
) {
}
