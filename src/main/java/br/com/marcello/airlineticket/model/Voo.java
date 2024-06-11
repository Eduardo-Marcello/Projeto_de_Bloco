package br.com.marcello.airlineticket.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@AllArgsConstructor@NoArgsConstructor
@Entity
@Table(name = "TB_VOO")
public class Voo {
    @NotBlank
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank @Size(min = 4, max = 10)
    private String codigo;
    @Column(name = "nome_empresa")
    private String empresa;
    private String destino;
    @Column(name = "status_situacao")
    private String situacao;
    private LocalDateTime data_hora_partida;
    private LocalDateTime data_hora_chegada;


}


