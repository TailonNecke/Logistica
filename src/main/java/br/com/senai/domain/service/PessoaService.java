package br.com.senai.domain.service;


import br.com.senai.api.assembler.PessoaAssembler;
import br.com.senai.api.model.PessoaDTO;
import br.com.senai.domain.exception.NegocioException;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.repository.PessoaRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;
import java.util.List;

@AllArgsConstructor
@Service
public class PessoaService {

    private PessoaRepository pessoaRepository;
    private PessoaAssembler pessoaAssembler;

    @Transactional
    public Pessoa cadastrar(Pessoa pessoa){
//        boolean emailValidation = pessoaRepository.findByEmail(pessoa.getEmail()).isPresent();
//
//        if (emailValidation){
//            throw new NegocioException("Ja existe uma pessoa com esse e-mail cadastrado");
//        }

        return pessoaRepository.save(pessoa);
    }

    public List<PessoaDTO> listar(){
        return pessoaAssembler.toCollectionModel(pessoaRepository.findAll());
    }

    public List<PessoaDTO> listarPorNome(String pessoaNome){
        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNome(pessoaNome));
    }
    public List<PessoaDTO> listarNomeContaining(String nomeContaining){
        return pessoaAssembler.toCollectionModel(pessoaRepository.findByNomeContaining(nomeContaining));
    }

    public Pessoa buscar(Long pessoaId){
       return pessoaRepository.findById(pessoaId).orElseThrow(() -> new NegocioException("Pessoa não encontrada."));
    }

    public ResponseEntity<PessoaDTO> procurar(Long pessoaId){
        return pessoaRepository.findById(pessoaId).map(entrega ->
            ResponseEntity.ok(pessoaAssembler.toModel(entrega))
        ).orElse(ResponseEntity.notFound().build());
    }
    public ResponseEntity<Pessoa> editar(@Valid @PathVariable Long pessoaId, @RequestBody Pessoa pessoa){
        if(!pessoaRepository.existsById(pessoaId)){ return ResponseEntity.notFound().build(); }
    pessoa.setId(pessoaId);
    pessoa = pessoaRepository.save(pessoa);
    return ResponseEntity.ok(pessoa);
    }

    @Transactional
    public void excluir(Long pessoaId){
        pessoaRepository.deleteById(pessoaId);
    }

}
