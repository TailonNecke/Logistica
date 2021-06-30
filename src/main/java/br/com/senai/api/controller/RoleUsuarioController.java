package br.com.senai.api.controller;

import br.com.senai.api.model.RoleUsuariosDTO;
import br.com.senai.api.model.input.RoleUsuariosInputDTO;
import br.com.senai.domain.service.RoleUsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/roleUsuarios")
public class RoleUsuarioController {


    private RoleUsuariosService roleUsuariosService;

    @PutMapping("/{roleUsuariosId}")
    public RoleUsuariosDTO editar(@PathVariable Long roleUsuariosId, @RequestBody RoleUsuariosInputDTO roleUsuariosInputDTO) {
        RoleUsuariosDTO roleUsuariosDTO = roleUsuariosService.editar(roleUsuariosId, roleUsuariosInputDTO).getBody();
        return roleUsuariosDTO;
    }

}
