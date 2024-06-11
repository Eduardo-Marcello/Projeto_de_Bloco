package br.com.marcello.airlineticket.repository;

import br.com.marcello.airlineticket.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VooRepository extends JpaRepository<Voo, Integer> {
}
