package com.example.project_school.dto.turmas;

import com.example.project_school.domain.turmas.Turma;
import com.example.project_school.domain.turmas.Turno;

public record DetalhamentoTurmaDTO(
        Long id,
        String nome,
        Turno turno,
        int ano
) {
    public DetalhamentoTurmaDTO(Turma turma) {
        this(turma.getId(), turma.getNome(), turma.getTurno(), turma.getAno());
    }
}
