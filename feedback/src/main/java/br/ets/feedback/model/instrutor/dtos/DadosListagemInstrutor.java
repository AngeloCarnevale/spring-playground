package br.ets.feedback.model.instrutor.dtos;

import br.ets.feedback.model.instrutor.Instrutor;
import br.ets.feedback.model.instrutor.enums.CursoEnum;

public record DadosListagemInstrutor(
        String nome,
        String email,
        String edv,
        Boolean ferias,
        CursoEnum curso
) {
    public DadosListagemInstrutor(Instrutor instrutor) {
        this(instrutor.getNome(),
                instrutor.getEmail(),
                instrutor.getEdv(),
                instrutor.getFerias(),
                instrutor.getCurso()
                );
    }
}
