package com.example.project_school.dto.turmas;

import com.example.project_school.domain.turmas.Turno;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotNull;

public record AtualizarTurmaDTO(
        @NotNull
        Long id,
        String nome,
        @Enumerated
        Turno turno,
        int ano
) {
}
