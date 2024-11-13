package com.example.project_school.dto.boletins;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateBoletimDTO(
        @NotNull
        float nota_1,
        @NotNull
        float nota_2,
        @NotNull
        float nota_3,
        @NotNull
        float nota_4,
        @NotNull
        Long id_aluno,

        @NotNull
        int quantidade_faltas
) {
}
