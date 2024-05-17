package br.com.marcello.airlineticket.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor@NoArgsConstructor
public class Voo {
    private int id;
    private String codigo;
    private String empresa;
    private String destino;
    private String situacao;
    private LocalDateTime data_hora_partida;
    private LocalDateTime data_hora_chegada;


}


