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
@Table(name = "VOO")
public class Voo {
    @NotBlank
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank @Size(min = 4, max = 10)
    private String codigo;
    private String destino;
    @Column(name = "data_hora_partida")
    private LocalDateTime dataHoraPartida;
    @Column(name = "data_hora_chegada")
    private LocalDateTime dataHoraChegada;
    @ManyToOne
    @JoinColumn(name = "status_id")
    private Situacao situacao;
    @ManyToOne
    @JoinColumn(name = "empresa_id")
    private Empresa empresa;

}


