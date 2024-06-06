package br.ets.feedback.model.instrutor.dtos;

import br.ets.feedback.model.instrutor.enums.CursoEnum;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoInstrutor(@NotNull int id,
                                        String nome,
                                        String email,
                                        String edv,
                                        CursoEnum curso,
                                        Boolean ferias

) {}
