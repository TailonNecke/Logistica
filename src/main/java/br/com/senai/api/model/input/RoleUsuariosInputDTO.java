package br.com.senai.api.model.input;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleUsuariosInputDTO {

    private String role_nome_role;
    private  Long usuario_id;
}
