package br.com.marcello.airlineticket.service;

import br.com.marcello.airlineticket.filters.VooFilters;
import br.com.marcello.airlineticket.model.Voo;

import java.util.List;
import java.util.Optional;

public interface VooService {
    List<Voo> getAll();
    Optional<Voo> getById(int id);
    void deleteById(int id);
    void save(Voo voo);
    Voo update(Integer id, Voo vooUpdate);
    List<Voo> findWithFilters(VooFilters filters);
}
