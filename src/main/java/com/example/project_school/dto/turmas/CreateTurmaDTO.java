package com.example.project_school.dto.turmas;

import com.example.project_school.domain.turmas.Turno;
import jakarta.persistence.Enumerated;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CreateTurmaDTO(
        @NotBlank
        String nome,
        @Enumerated
        Turno turno,
        @NotNull
        int ano
) {
}
