package com.example.project_school.dto.boletins;

import com.example.project_school.domain.alunos.Aluno;
import com.example.project_school.domain.boletins.Boletim;

public record ListBoletimDTO(Long id, float nota1, float nota2, float nota3, float nota4, Aluno aluno, int quantidadeFaltas, boolean aprovado) {
    public ListBoletimDTO(Boletim boletim) {
        this(boletim.getId(), boletim.getNota_1(), boletim.getNota_2(), boletim.getNota_3(), boletim.getNota_4(), boletim.getAluno(), boletim.getQuantidadeFaltas(), boletim.isAprovado());
    }
}
