package com.example.project_school.dto.users;

import com.example.project_school.domain.users.User;

public record ListUsersDTO (Long id, String nome, String email) {

    public ListUsersDTO(User user) {
        this(user.getId(), user.getNome(), user.getEmail());
    }
}
