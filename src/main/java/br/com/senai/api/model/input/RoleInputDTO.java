package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Id;

@Getter
@Setter
public class RoleInputDTO {

    @Id
    private String nome_role;
}
