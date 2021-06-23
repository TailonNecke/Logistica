package br.com.senai.domain.service;

import br.com.senai.domain.model.Pessoa;
import br.com.senai.domain.model.Role;
import br.com.senai.domain.repository.RoleRepository;
import org.springframework.transaction.annotation.Transactional;


public class RoleService {

    @Transactional
    public Role cadastrar(Role role) {

        return RoleRepository.save(role);
    }
}
