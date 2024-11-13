package com.example.project_school.controllers;

import com.example.project_school.dto.users.DetalhamentoUsuarioDTO;
import com.example.project_school.dto.users.ListUsersDTO;
import com.example.project_school.dto.users.AtualizarUsuarioDTO;
import com.example.project_school.repositories.UserRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserRepository repository;

    @GetMapping
    public ResponseEntity getAll() {
        List<ListUsersDTO> usersList = this.repository.findAll().stream().map(ListUsersDTO::new).toList();

        return ResponseEntity.ok(usersList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var usuario = this.repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoUsuarioDTO(usuario));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid AtualizarUsuarioDTO dados) {
        var usuario = this.repository.getReferenceById(dados.id());
        usuario.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoUsuarioDTO(usuario));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        this.repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
