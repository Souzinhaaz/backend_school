package com.example.project_school.repositories;

import com.example.project_school.domain.alunos.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Long> {
}
