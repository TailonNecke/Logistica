CREATE TABLE ocorrencia(
    id bigint not null auto_increment,
    entrega_id int not null,
    descricao text not null,
    data_registro timestamp not null,
    primary key (id)
);

ALTER TABLE ocorrencia ADD CONSTRAINT fk_ocorrencia_entrega
FOREIGN KEY (entrega_id) REFERENCES entregas (id);