package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

@Getter
@Setter
public class PessoaInput {

    @NotNull
    private long id;

    private String email;

    private String nome;

    private String telefone;

}