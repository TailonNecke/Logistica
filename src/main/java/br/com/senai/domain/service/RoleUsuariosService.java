package br.com.senai.domain.service;

import br.com.senai.api.assembler.RoleUsuariosAssembler;
import br.com.senai.api.model.RoleUsuariosDTO;
import br.com.senai.api.model.input.RoleUsuariosInputDTO;
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
    private RoleUsuariosAssembler roleUsuariosAssembler;

    public ResponseEntity<RoleUsuariosDTO> editar(@Valid @PathVariable Long roleUsuariosId, @RequestBody RoleUsuariosInputDTO roleUsuariosInputDTO){
//        if(!roleUsuariosRepository.existsById(roleUsuariosId)){ return ResponseEntity.notFound().build(); }

        RoleUsuarios roled = roleUsuariosRepository.findById(roleUsuariosId).orElse(null);
        roled.setRole_nome_role(roleUsuariosInputDTO.getRole_nome_role());
        roleUsuariosRepository.save(roled);

        return ResponseEntity.ok(roleUsuariosAssembler.toModel(roled));
    }

}
