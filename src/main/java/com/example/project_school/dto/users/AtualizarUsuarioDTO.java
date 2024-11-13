package com.example.project_school.dto.users;

import jakarta.validation.constraints.NotNull;

public record AtualizarUsuarioDTO(
        @NotNull
        Long id,
        String nome,
        String email,
        String senha
) {
}
