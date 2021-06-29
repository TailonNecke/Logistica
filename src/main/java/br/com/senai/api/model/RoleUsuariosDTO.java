package br.com.senai.api.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleUsuariosDTO {

    private long id;
    private String role_nome_role;
    private  Long usuario_id;
}
