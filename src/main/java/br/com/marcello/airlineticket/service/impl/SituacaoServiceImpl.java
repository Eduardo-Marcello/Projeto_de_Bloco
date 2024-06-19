package br.com.marcello.airlineticket.service.impl;

import br.com.marcello.airlineticket.model.Situacao;
import br.com.marcello.airlineticket.repository.SituacaoRepository;
import br.com.marcello.airlineticket.service.SituacaoService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class SituacaoServiceImpl implements SituacaoService {

    private final SituacaoRepository situacaoRepository;

    @Override
    public List<Situacao> findAll() {
        return situacaoRepository.findAll();
    }

    @Override
    public Optional<Situacao> findById(Long id) {
        return situacaoRepository.findById(id);
    }
}
