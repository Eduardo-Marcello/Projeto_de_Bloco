package br.com.marcello.airlineticket.service.impl;

import br.com.marcello.airlineticket.filters.VooFilters;
import br.com.marcello.airlineticket.model.Voo;
import br.com.marcello.airlineticket.repository.VooRepository;
import br.com.marcello.airlineticket.service.VooService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class VooServiceImpl implements VooService {
    private final VooRepository vooRepository;
    private final EntityManager entityManager;

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

    @Override
    public List<Voo> findWithFilters(VooFilters filters) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Voo> cq = cb.createQuery(Voo.class);
        Root<Voo> voo =  cq.from(Voo.class);
        List<Predicate> predicates = new ArrayList<>();
        if (filters.getCodigo().isPresent()) {
            String query = filters.getCodigo().get() + "%";
            Predicate codigo = cb.like(voo.get("codigo"), query);
            predicates.add(codigo);
        }
        if(filters.getDestino().isPresent()){
            String query = filters.getDestino().get() + "%";
            Predicate destino = cb.like(voo.get("destino"), query);
            predicates.add(destino);
        }
        if (filters.getDataHoraPartida().isPresent()){
            String query = filters.getDataHoraPartida().get() + "%";
            Predicate dataHoraPartida = cb.like(voo.get("dataHora"), query);
            predicates.add(dataHoraPartida);
        }
        if(filters.getDataHoraChegada().isPresent()){
            String query = filters.getDataHoraChegada().get() + "%";
            Predicate dataHoraChegada = cb.like(voo.get("dataHora"), query);
            predicates.add(dataHoraChegada);
        }
        if(filters.getSituacao().isPresent()){
            Predicate situacao = cb.equal(voo.get("situacao"), filters.getSituacao().get());
            predicates.add(situacao);
        }
        if(filters.getEmpresa().isPresent()){
            Predicate empresa = cb.equal(voo.get("empresa"), filters.getEmpresa().get());
            predicates.add(empresa);
        }
        if(filters.getPais().isPresent()){
           Predicate pais = cb.equal(voo.get("empresa").<String>get("pais"), filters.getPais().get());
           predicates.add(pais);
        }
        cq.where(predicates.toArray(Predicate[]:: new));
        List<Voo> resultList = entityManager.createQuery(cq).getResultList();
        return resultList;
    }

}
