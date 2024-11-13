package com.example.project_school.controllers;

import com.example.project_school.dto.turmas.AtualizarTurmaDTO;
import com.example.project_school.dto.turmas.CreateTurmaDTO;
import com.example.project_school.dto.turmas.DetalhamentoTurmaDTO;
import com.example.project_school.dto.turmas.ListTurmaDTO;
import com.example.project_school.domain.turmas.Turma;
import com.example.project_school.repositories.TurmaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/turmas")
public class TurmaController {

    @Autowired
    private TurmaRepository repository;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CreateTurmaDTO body) {
        Turma newTurma = new Turma(body);

        this.repository.save(newTurma);
        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<ListTurmaDTO> turmaList = this.repository.findAll().stream().map(ListTurmaDTO::new).toList();

        return ResponseEntity.ok(turmaList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var turma = this.repository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoTurmaDTO(turma));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid AtualizarTurmaDTO dados) {
        var turma = this.repository.getReferenceById(dados.id());
        turma.atualizarInformacoes(dados);

        return ResponseEntity.ok(new DetalhamentoTurmaDTO(turma));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        this.repository.deleteById(id);

        return ResponseEntity.noContent().build();
    }

}
