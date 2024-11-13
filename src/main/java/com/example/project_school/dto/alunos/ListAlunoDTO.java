package com.example.project_school.dto.alunos;

import com.example.project_school.domain.alunos.Aluno;
import com.example.project_school.domain.turmas.Turma;
import com.example.project_school.domain.turmas.Turno;

public record ListAlunoDTO(Long id, String nome, String email, Turma turma, String responsibleTelephone) {

    public ListAlunoDTO(Aluno aluno) {
        this(aluno.getId(), aluno.getNome(), aluno.getEmail(), aluno.getTurma(), aluno.getResponsibleTelephone());
    }
}
