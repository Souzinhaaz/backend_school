package com.example.project_school.dto.alunos;

import com.example.project_school.domain.alunos.Aluno;
import com.example.project_school.domain.turmas.Turma;

public record DetalhamentoAlunoDTO(Long id, String nome, String email, Turma turma, String responsibleTelephone) {
    public DetalhamentoAlunoDTO(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTurma(), aluno.getResponsibleTelephone());
    }
}
