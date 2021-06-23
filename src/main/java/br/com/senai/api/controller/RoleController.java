package br.com.senai.api.controller;

import br.com.senai.api.assembler.RoleAssembler;
import br.com.senai.api.model.PessoaDTO;
import br.com.senai.api.model.RoleDTO;
import br.com.senai.api.model.input.PessoaInputDTO;
import br.com.senai.api.model.input.RoleInputDTO;
import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.service.RoleService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@AllArgsConstructor
@RestController
public class RoleController {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public RoleDTO cadastrar(@Valid @RequestBody RoleInputDTO roleInputDTO) {
        Role roled = RoleAssembler.toEntity(roleInputDTO);

        Role roledi = RoleService.cadastrar(roled);

        return RoleAssembler.toModel(roledi);
    }
}
