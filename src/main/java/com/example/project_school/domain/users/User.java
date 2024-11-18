package com.example.project_school.domain.users;

import com.example.project_school.dto.users.AtualizarUsuarioDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

@Entity(name = "usuarios")
@Table(name = "usuarios")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String senha;

    public void atualizarInformacoes(@Valid AtualizarUsuarioDTO dados, PasswordEncoder passwordEncoder) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.email() != null) {
            this.email = dados.email();
        }

        if (dados.senha() != null) {
            this.senha = passwordEncoder.encode(dados.senha());
        }
    }

}
