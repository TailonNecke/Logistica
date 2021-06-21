package br.com.senai.api.controller;


import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaModel;
import br.com.senai.api.model.input.PessoaInput;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import br.com.senai.domain.service.PessoaService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/pessoas")
public class PessoaController {

    private PessoaRepository pessoaRepository;
    private PessoaService pessoaService;
    private PessoaAssembler pessoaAssembler;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaModel cadastrar(@Valid @RequestBody PessoaInput pessoaInput) {
        Pessoa pessoinhenta = pessoaAssembler.toEntity(pessoaInput);
        Pessoa pessoinhento = pessoaService.cadastrar(pessoinhenta);
        return pessoaAssembler.toModel(pessoinhento);
    }

    @GetMapping()
    public List<PessoaModel> listar(){
        return pessoaService.listar();
    }

    @GetMapping("/nome/{pessoaNome}")
    public List<PessoaModel> listarPorNome(@PathVariable String pessoaNome){
        return pessoaService.listarPorNome(pessoaNome);
    }
//    public List<Pessoa> listarPorNome(@PathVariable String pessoaNome){
//        return pessoaRepository.findByNome(pessoaNome);
//    }

    @GetMapping("/nome/containing/{nomeContaining}")
    public List<PessoaModel> listarNomeContaining(@PathVariable String nomeContaining){
        return pessoaService.listarNomeContaining(nomeContaining);
    }
//    public List<Pessoa> listarNomeContaining(@PathVariable String nomeContaining) {
//        return pessoaRepository.findByNomeContaining(nomeContaining);
//    }

    @GetMapping("/{pessoaId}")
    public ResponseEntity<PessoaModel> buscar(@PathVariable Long pessoaId){
        return pessoaService.procurar(pessoaId);
    }

//@PostMapping
//@ResponseStatus(HttpStatus.CREATED)
//public PessoaModel cadastrar(@Valid @RequestBody Pessoa pessoa, PessoaInput pessoaInput) {
//    pessoaService.cadastrar(pessoa);
//    pessoaInput.setNome(pessoa.getNome());
//    pessoaInput.setEmail(pessoa.getEmail());
//    pessoaInput.setTelefone(pessoa.getTelefone());
//    return pessoaInput;
//}

    @PutMapping("/{pessoaId}")
    @ResponseStatus(HttpStatus.CREATED)
    public PessoaModel editar(@Valid @PathVariable Long pessoaId, @RequestBody PessoaInput pessoaInput) {
        Pessoa pessoinha = pessoaAssembler.toEntity(pessoaInput);
        ResponseEntity<Pessoa> pessoaResponseEntity = pessoaService.editar(pessoaId, pessoinha);
        return pessoaAssembler.toModel(pessoaResponseEntity.getBody());

    }
    @DeleteMapping("/{pessoaId}")
    public ResponseEntity<Pessoa> remover(@Valid @PathVariable Long pessoaId) {

        if(!pessoaRepository.existsById(pessoaId)){
            return ResponseEntity.notFound().build();
        }

        pessoaService.excluir(pessoaId);

        return ResponseEntity.noContent().build();
    }

}
