package br.com.marcello.airlineticket.service;

import br.com.marcello.airlineticket.filters.VooFilters;
import br.com.marcello.airlineticket.model.Situacao;
import br.com.marcello.airlineticket.model.Voo;

import java.util.List;
import java.util.Optional;

public interface VooService {
    List<Voo> getAll();
    Optional<Voo> getById(Long id);
    void deleteById(Long id);
    void save(Voo voo);
    Voo update(Long id, Voo vooUpdate);
    List<Voo> findWithFilters(VooFilters filters);
    List<Voo> findAllNationals();
    List<Voo> findAllInternationals();
    List<Voo> findAllStatusNormal(List<Situacao> situacao);
    List<Voo> findbyCode(String code);
}
