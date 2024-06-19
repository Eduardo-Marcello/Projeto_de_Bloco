package br.com.marcello.airlineticket.repository;

import br.com.marcello.airlineticket.model.Situacao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SituacaoRepository  extends JpaRepository<Situacao, Long> {

}
