package com.example.project_school.dto.boletins;

import jakarta.validation.constraints.NotNull;

public record AtualizarBoletimDTO(
        @NotNull
        Long id,
        float nota_1,
        float nota_2,
        float nota_3,
        float nota_4,
        Long id_aluno,
        int quantidade_faltas
) {
}
