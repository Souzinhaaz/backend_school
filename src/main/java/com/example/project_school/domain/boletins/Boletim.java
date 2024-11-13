package com.example.project_school.domain.boletins;

import com.example.project_school.domain.alunos.Aluno;
import com.example.project_school.dto.boletins.AtualizarBoletimDTO;
import com.example.project_school.dto.boletins.CreateBoletimDTO;
import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.*;

@Table(name = "Boletins")
@Entity(name = "boletins")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Boletim {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private float nota_1;

    @Column(nullable = false)
    private float nota_2;

    @Column(nullable = false)
    private float nota_3;

    @Column(nullable = false)
    private float nota_4;

    @Column(nullable = false)
    private float media;

    @ManyToOne
    @JoinColumn(name = "id_aluno", nullable = false)
    private Aluno aluno;

    @Column(nullable = false)
    private int quantidadeFaltas;

    private boolean aprovado;

    public Boletim (CreateBoletimDTO dados, Aluno aluno) {
        this.nota_1 = dados.nota_1();
        this.nota_2 = dados.nota_2();
        this.nota_3 = dados.nota_3();
        this.nota_4 = dados.nota_4();
        this.aluno = aluno;
        this.quantidadeFaltas = dados.quantidade_faltas();
        this.estaAprovado(this.nota_1, this.nota_2, this.nota_3, this.nota_4, this.quantidadeFaltas);
    }

    public void atualizarInformacoes(@Valid AtualizarBoletimDTO dados, Aluno novoAluno) {
        if (dados.nota_1() > 0 && dados.nota_1() <= 10) {
            this.nota_1 = dados.nota_1();
        }

        if (dados.nota_2() > 0 && dados.nota_2() <= 10) {
            this.nota_2 = dados.nota_2();
        }

        if (dados.nota_3() > 0 && dados.nota_3() <= 10) {
            this.nota_3 = dados.nota_3();
        }

        if (dados.nota_4() > 0 && dados.nota_4() <= 10) {
            this.nota_4 = dados.nota_4();
        }

        if (novoAluno != null) {
            this.aluno = novoAluno;
        }

        if (dados.quantidade_faltas() > 0) {
            this.quantidadeFaltas = dados.quantidade_faltas();
        }

        this.estaAprovado(this.nota_1, this.nota_2, this.nota_3, this.nota_4, this.quantidadeFaltas);
    }

    private void setMedia(float nota1, float nota2, float nota3, float nota4) {
        this.media = (nota1 + nota2 + nota3 + nota4) / 4;
    }

    private void estaAprovado(float nota1, float nota2, float nota3, float nota4, int quantidadeFaltas) {
        this.setMedia(nota1, nota2, nota3, nota4);

        this.aprovado = this.media >= 7 && this.quantidadeFaltas < 15;
    }

}
