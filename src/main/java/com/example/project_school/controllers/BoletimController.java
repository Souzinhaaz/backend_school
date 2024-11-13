package com.example.project_school.controllers;

import com.example.project_school.domain.alunos.Aluno;
import com.example.project_school.domain.boletins.Boletim;
import com.example.project_school.dto.alunos.AtualizarAlunoDTO;
import com.example.project_school.dto.alunos.DetalhamentoAlunoDTO;
import com.example.project_school.dto.boletins.AtualizarBoletimDTO;
import com.example.project_school.dto.boletins.CreateBoletimDTO;
import com.example.project_school.dto.boletins.DetalhamentoBoletimDTO;
import com.example.project_school.dto.boletins.ListBoletimDTO;
import com.example.project_school.repositories.AlunoRepository;
import com.example.project_school.repositories.BoletimRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boletins")
public class BoletimController {

    @Autowired
    private BoletimRepository boletimRepository;
    @Autowired
    private AlunoRepository alunoRepository;

    @PostMapping
    public ResponseEntity create(@RequestBody @Valid CreateBoletimDTO body) {
        Aluno aluno = this.alunoRepository.findById(body.id_aluno())
                .orElseThrow(() -> new IllegalArgumentException("Aluno não encontrado"));

        Boletim newBoletim = new Boletim(body, aluno);
        this.boletimRepository.save(newBoletim);

        return ResponseEntity.ok().build();
    }

    @GetMapping
    public ResponseEntity getAll() {
        List<ListBoletimDTO> boletimList = this.boletimRepository.findAll().stream().map(ListBoletimDTO::new).toList();

        return ResponseEntity.ok(boletimList);
    }

    @PutMapping
    @Transactional
    public ResponseEntity update(@RequestBody @Valid AtualizarBoletimDTO dados) {
        var boletim = this.boletimRepository.getReferenceById(dados.id_aluno());
        var aluno = this.alunoRepository.getReferenceById(dados.id());
        boletim.atualizarInformacoes(dados, aluno);

        return ResponseEntity.ok(new DetalhamentoBoletimDTO(boletim));
    }


    @GetMapping("/{id}")
    public ResponseEntity getById(@PathVariable Long id) {
        var boletim = this.boletimRepository.getReferenceById(id);

        return ResponseEntity.ok(new DetalhamentoBoletimDTO(boletim));
    }



    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity delete(@PathVariable Long id) {
        this.boletimRepository.deleteById(id);

        return ResponseEntity.noContent().build();
    }
}
