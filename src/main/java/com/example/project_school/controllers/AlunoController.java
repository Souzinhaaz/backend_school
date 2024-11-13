package com.example.project_school.controllers;

import com.example.project_school.domain.alunos.Aluno;
import com.example.project_school.dto.alunos.AtualizarAlunoDTO;
import com.example.project_school.dto.alunos.CreateAlunoDTO;
import com.example.project_school.dto.alunos.DetalhamentoAlunoDTO;
import com.example.project_school.dto.alunos.ListAlunoDTO;
import com.example.project_school.domain.turmas.Turma;
import com.example.project_school.repositories.AlunoRepository;
import com.example.project_school.repositories.TurmaRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository alunoRepository;
    @Autowired
    private TurmaRepository turmaRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CreateAlunoDTO body) {
        Turma turma = this.turmaRepository.findById(body.id_turma())
                .orElseThrow(() -> new IllegalArgumentException("Turma não encontrada"));
        Aluno newAluno = new Aluno(body, turma);

        this.alunoRepository.save(newAluno);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<ListAlunoDTO> alunoList = this.alunoRepository.findAll().stream().map(ListAlunoDTO::new).toList();

        return ResponseEntity.ok(alunoList);
    }

    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var aluno = this.alunoRepository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoAlunoDTO(aluno));
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid AtualizarAlunoDTO dados) {
        var aluno = this.alunoRepository.getReferenceById(dados.id());
        var turma = this.turmaRepository.getReferenceById(dados.id_turma());
        aluno.atualizarInformacoes(dados, turma);

        return ResponseEntity.ok(new DetalhamentoAlunoDTO(aluno));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        this.alunoRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
