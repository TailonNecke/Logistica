package br.com.senai.api.model;

import br.com.senai.domain.model.StatusEntrega;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Getter
@Setter
public class EntregaDTO {

    private long id;
    private String pessoa;
    private DestinatarioDTO destinatario;
    private BigDecimal taxa;
    private LocalDateTime dataPedido;
    private LocalDateTime dataFinalizacao;
    private StatusEntrega status;

}
