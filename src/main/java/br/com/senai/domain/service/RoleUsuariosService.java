package br.com.senai.domain.service;

import br.com.senai.domain.model.RoleUsuarios;
import br.com.senai.domain.repository.RoleUsuariosRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@AllArgsConstructor
@Service
public class RoleUsuariosService {

    private RoleUsuariosRepository roleUsuariosRepository;

    public ResponseEntity<RoleUsuarios> editar(@Valid @PathVariable Long roleUsuariosId, @RequestBody RoleUsuarios roleUsuarios){
        if(!roleUsuariosRepository.existsById(roleUsuariosId)){ return ResponseEntity.notFound().build(); }
        roleUsuarios.setId(roleUsuariosId);
        roleUsuarios = roleUsuariosRepository.save(roleUsuarios);
        return ResponseEntity.ok(roleUsuarios);
    }

}
