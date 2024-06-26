package br.ets.feedback.controllers;

import br.ets.feedback.model.instrutor.Instrutor;
import br.ets.feedback.model.instrutor.dtos.DadosAtualizacaoInstrutor;
import br.ets.feedback.model.instrutor.dtos.DadosCadastroInstrutor;
import br.ets.feedback.model.instrutor.dtos.DadosListagemInstrutor;
import br.ets.feedback.model.instrutor.repository.InstrutorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/instrutor")
public class InstrutorController {

    @Autowired
    private InstrutorRepository repository;

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public Instrutor cadastrar(@RequestBody @Valid DadosCadastroInstrutor dadosCadastroInstrutor) {
        Instrutor instrutor = new Instrutor(dadosCadastroInstrutor);
        return repository.save(instrutor);
    }

    @GetMapping
    public Page<DadosListagemInstrutor> listar(Pageable pageable) {
        return repository.findAll(pageable).map(DadosListagemInstrutor::new);
    }

    @GetMapping("/{id}")
    public Instrutor procurar(@PathVariable Integer id) {
        var instrutor = repository.findById(id);
        if (instrutor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        return instrutor.get();
    }

    @Transactional
    @PutMapping
    public void update(@RequestBody @Valid DadosAtualizacaoInstrutor dadosAtualizacaoInstrutor) {
        var instrutor = repository.getReferenceById(dadosAtualizacaoInstrutor.id());

        instrutor.atualizar(dadosAtualizacaoInstrutor);
    }

    @DeleteMapping("/{id}")
    public void remover(@PathVariable Integer id) {
        var instrutor = repository.findById(id);
        if (instrutor.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
        repository.delete(instrutor.get());
    }
}
