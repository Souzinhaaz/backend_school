package com.example.project_school.domain.alunos;

import com.example.project_school.domain.turmas.Turma;
import com.example.project_school.dto.alunos.AtualizarAlunoDTO;
import com.example.project_school.dto.alunos.CreateAlunoDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "Alunos")
@Entity(name = "alunos")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_turma", nullable = false)
    private Turma turma;

    @Column(nullable = false)
    private String responsibleTelephone;

    public Aluno (CreateAlunoDTO dados, Turma turma) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.turma = turma;
        this.responsibleTelephone = dados.responsibleTelephone();
    }

    public void atualizarInformacoes(@Valid AtualizarAlunoDTO dados, Turma novaTurma) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.email() != null) {
            this.email = dados.email();
        }

        if (novaTurma != null) {
            this.turma = novaTurma;
        }

        if (dados.responsibleTelephone() != null) {
            this.responsibleTelephone = dados.responsibleTelephone();
        }

    }

}
