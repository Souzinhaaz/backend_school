package com.example.project_school.dto.users;

import com.example.project_school.domain.users.User;

public record DetalhamentoUsuarioDTO(
        Long id,
        String nome,
        String email
) {
    public DetalhamentoUsuarioDTO (User user) {
        this(
                user.getId(),
                user.getNome(),
                user.getEmail()
        );
    }
}
