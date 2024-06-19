package br.com.marcello.airlineticket.service;


import br.com.marcello.airlineticket.model.Situacao;

import java.util.List;
import java.util.Optional;

public interface SituacaoService {

    List<Situacao> findAll();
    Optional<Situacao> findById(Long id);
}
