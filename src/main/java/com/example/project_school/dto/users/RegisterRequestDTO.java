package com.example.project_school.dto.users;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record RegisterRequestDTO (
        @NotBlank
        String nome,
        @NotBlank
        String email,
        @NotBlank
        String senha
) {
}
