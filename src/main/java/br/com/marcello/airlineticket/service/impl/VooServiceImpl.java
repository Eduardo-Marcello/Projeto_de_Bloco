package br.com.marcello.airlineticket.service.impl;

import br.com.marcello.airlineticket.model.Voo;
import br.com.marcello.airlineticket.repository.VooRepository;
import br.com.marcello.airlineticket.service.VooService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VooServiceImpl implements VooService {
    private final VooRepository vooRepository;

    @Override
    public List<Voo> getAll() {
        return vooRepository.findAll();
    }

    @Override
    public Optional<Voo> getById(int id) {
        return vooRepository.findById(id);

    }

    @Override
    public void deleteById(int id) {
        vooRepository.deleteById(id);
    }

    @Override
    public void save(Voo voo) {
        vooRepository.save(voo);
    }

    @Override
    public Voo update(Integer id, Voo vooUpdate) {
        vooUpdate.setId(id);
        return vooRepository.save(vooUpdate);
    }

}
