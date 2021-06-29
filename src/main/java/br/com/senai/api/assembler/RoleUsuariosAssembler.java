package br.com.senai.api.assembler;


import br.com.senai.api.model.RoleUsuariosDTO;
import br.com.senai.api.model.input.RoleUsuariosInputDTO;
import br.com.senai.domain.model.RoleUsuarios;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Component
public class RoleUsuariosAssembler {

    private ModelMapper modelMapper;

    public RoleUsuariosDTO toModel(RoleUsuarios roleUsuarios){
        return modelMapper.map(roleUsuarios, RoleUsuariosDTO.class);
    }

    public List<RoleUsuariosDTO> toCollectionModel(List<RoleUsuarios> roleUsuarioss){
        return roleUsuarioss.stream().map(this::toModel).collect(Collectors.toList());
    }

    public RoleUsuarios toEntity(RoleUsuariosInputDTO roleUsuariosInputDTO){
        return modelMapper.map(roleUsuariosInputDTO, RoleUsuarios.class);
    }
}
