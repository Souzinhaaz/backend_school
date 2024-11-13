package com.example.project_school.domain.turmas;

import com.example.project_school.dto.turmas.AtualizarTurmaDTO;
import com.example.project_school.dto.turmas.CreateTurmaDTO;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "Turmas")
@Entity(name = "turmas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Turma {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String nome;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private Turno turno;

    @Column(nullable = false)
    private int ano;

    public Turma(CreateTurmaDTO dados) {
        this.nome = dados.nome();
        this.turno = dados.turno();
        this.ano = dados.ano();
    }

    public void atualizarInformacoes(@Valid AtualizarTurmaDTO dados) {
        if (dados.nome() != null) {
            this.nome = dados.nome();
        }

        if (dados.turno() != null) {
            this.turno = dados.turno();
        }

        if (dados.ano() > 0) {
            this.ano = dados.ano();
        }
    }

}
