package br.com.marcello.airlineticket.filters;

import br.com.marcello.airlineticket.model.Empresa;
import br.com.marcello.airlineticket.model.Situacao;

import java.util.Date;
import java.util.Optional;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data@AllArgsConstructor@NoArgsConstructor@Builder
public class VooFilters {
    private Optional<String> codigo;
    private Optional<String> destino;
    private Optional<Date> dataHoraPartida;
    private Optional<Date> dataHoraChegada;
    private Optional<Situacao> situacao;
    private Optional<Empresa> empresa;
    private Optional<String> pais;

}
