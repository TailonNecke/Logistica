CREATE TABLE role_usuarios(
    usuarios_id bigint not null,
    role_nome_role varchar(45) not null
);

ALTER TABLE role_usuarios ADD CONSTRAINT fk_usuarios
FOREIGN key (usuarios_id) REFERENCES usuarios (id);

ALTER TABLE role_usuarios ADD CONSTRAINT fk_role
FOREIGN key (role_nome_role) REFERENCES role (nome_role);