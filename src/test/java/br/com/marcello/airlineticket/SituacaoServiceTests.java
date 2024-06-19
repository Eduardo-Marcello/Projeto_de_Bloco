package br.com.marcello.airlineticket;

import br.com.marcello.airlineticket.model.Situacao;
import br.com.marcello.airlineticket.repository.SituacaoRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class SituacaoServiceTests {

    @Autowired
    private SituacaoRepository situacaoRepository;

    @Test
    @DisplayName("Deve retornar todas as situações do banco")
    public void findAllTest(){
        List<Situacao> all = situacaoRepository.findAll();
        assertEquals(4, all.size());
    }

    @Test
    @DisplayName("Deve retornar o Id")
    public void findByIdTest(){
        Optional<Situacao> byId = situacaoRepository.findById(1L);
        assertTrue(byId.isPresent());
        Optional<Situacao> notExist = situacaoRepository.findById(9999L);
        assertTrue(notExist.isEmpty());
    }
}
