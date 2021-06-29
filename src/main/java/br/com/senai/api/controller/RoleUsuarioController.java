package br.com.senai.api.controller;

import br.com.senai.api.assembler.RoleUsuariosAssembler;
import br.com.senai.api.model.RoleUsuariosDTO;
import br.com.senai.api.model.input.RoleUsuariosInputDTO;
import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.service.RoleUsuariosService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
@AllArgsConstructor
@RestController
@RequestMapping("/roleUsuarios")
public class RoleUsuarioController {

    private RoleUsuariosAssembler roleUsuariosAssembler;
    private RoleUsuariosService roleUsuariosService;

    @PutMapping("/{roleUsuarioId}")
    @ResponseStatus(HttpStatus.CREATED)
    public RoleUsuariosDTO editar(@Valid @PathVariable Long roleUsuariosId, @RequestBody RoleUsuariosInputDTO roleUsuariosInputDTO) {
        RoleUsuarios roled = roleUsuariosAssembler.toEntity(roleUsuariosInputDTO);
        ResponseEntity<RoleUsuarios> roleUsuariosResponseEntity = roleUsuariosService.editar(roleUsuariosId, roled);
        return roleUsuariosAssembler.toModel(roleUsuariosResponseEntity.getBody());

    }

}
