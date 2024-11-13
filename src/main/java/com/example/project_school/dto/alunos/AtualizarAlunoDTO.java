package com.example.project_school.dto.alunos;

import jakarta.validation.constraints.NotNull;

public record AtualizarAlunoDTO(
        @NotNull
        Long id,
        String nome,
        String email,
        Long id_turma,
        String responsibleTelephone
) {
}
