package br.com.senai.domain.repository;

import br.com.senai.domain.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

    public class RoleRepository extends JpaRepository<Role, String> {

    List<Role> findByNome(String nome);

    List<Role> findByNomeContaining(String nome);

}
