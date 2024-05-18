package br.com.marcello.airlineticket.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor@NoArgsConstructor
public class Voo {
    @NotBlank
    private int id;
    @NotBlank @Size(min = 4, max = 10)
    private String codigo;
    private String empresa;
    private String destino;
    private String situacao;
    private LocalDateTime data_hora_partida;
    private LocalDateTime data_hora_chegada;


}


