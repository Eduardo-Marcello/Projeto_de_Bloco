package br.com.marcello.airlineticket.repository;

import br.com.marcello.airlineticket.model.Situacao;
import br.com.marcello.airlineticket.model.Voo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VooRepository extends JpaRepository<Voo, Long> {
    @Query("select v from Voo v where v.codigo like '3%'")
    List<Voo> findAllNationals();

    @Query("select v from Voo v where v.codigo like '4%'")
    List<Voo> findAllInternationals();

    @Query("select v from Voo v inner join v.situacao status where status in :situacao and status.status = 'Normal'")
    List<Voo> findAllStatusNormal(@Param("situacao")List<Situacao> situacao);

    @Query("select v from Voo v where v.codigo =:code")
    List<Voo> findByCode(@Param("code") String code);
}
