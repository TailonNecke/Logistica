package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PessoaModel {

    private Long id;
    private String nome;
    private String email;
    private String telefone;

}
