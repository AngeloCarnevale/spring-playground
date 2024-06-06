package br.ets.feedback.model.instrutor;

import br.ets.feedback.model.informacoes.Informacoes;
import br.ets.feedback.model.instrutor.dtos.DadosAtualizacaoInstrutor;
import br.ets.feedback.model.instrutor.dtos.DadosCadastroInstrutor;
import br.ets.feedback.model.instrutor.enums.CursoEnum;
import jakarta.persistence.*;
import lombok.*;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Entity(name = "Instrutor")
@Table(name = "instrutor")
public class Instrutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nome;
    private String email;
    private String edv;


    @Enumerated(EnumType.STRING)
    private CursoEnum curso;

    @Embedded
    private Informacoes informacoes;
    private Boolean ferias;

    public Instrutor(DadosCadastroInstrutor dados) {
        this.nome = dados.nome();
        this.email = dados.email();
        this.edv = dados.edv();
        this.curso = dados.curso();
        this.informacoes = new Informacoes(dados.informacoes());
        this.ferias = dados.ferias();
    }

    public void atualizar(DadosAtualizacaoInstrutor dadosAtualizacaoInstrutor) {
        if(dadosAtualizacaoInstrutor.nome() != null){
            this.nome = dadosAtualizacaoInstrutor.nome();
        }

        if(dadosAtualizacaoInstrutor.email() != null){
            this.email = dadosAtualizacaoInstrutor.email();
        }
        if(dadosAtualizacaoInstrutor.edv() != null){
            this.edv = dadosAtualizacaoInstrutor.edv();
        }
        if(dadosAtualizacaoInstrutor.curso() != null){
            this.curso = dadosAtualizacaoInstrutor.curso();
        }
        if(dadosAtualizacaoInstrutor.ferias() != null){
            this.ferias = dadosAtualizacaoInstrutor.ferias();
        }


    }
}
