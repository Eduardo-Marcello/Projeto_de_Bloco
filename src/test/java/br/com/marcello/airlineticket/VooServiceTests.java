package br.com.marcello.airlineticket;

import br.com.marcello.airlineticket.model.Empresa;
import br.com.marcello.airlineticket.model.Situacao;
import br.com.marcello.airlineticket.model.Voo;
import br.com.marcello.airlineticket.repository.VooRepository;
import br.com.marcello.airlineticket.service.VooService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
@Slf4j
public class VooServiceTests {
    @Autowired
    VooService vooService;
    @Autowired
    private VooRepository vooRepository;

    @Test
    @DisplayName("Deve inserir um voo no Banco")
    public void testInsert(){
        Situacao situacao = Situacao.builder().id(1L).build();
        Empresa empresa = Empresa.builder().id(1L).build();
        List<Voo> all = vooService.getAll();
        int estadoInicial = all.size();
        Voo voo = new Voo();
        voo.setCodigo("3459");
        voo.setSituacao(situacao);
        voo.setEmpresa(empresa);
        vooService.save(voo);
        all = vooService.getAll();
        int estadoFinal = all.size();
        assertEquals(estadoInicial + 1, estadoFinal);
    }

    @Test
    @DisplayName("Deve deletar um voo do Banco")
    public void testDelete(){
        Situacao situacao = Situacao.builder().id(3L).build();
        Empresa empresa = Empresa.builder().id(1L).build();
        Voo voo = new Voo();
        voo.setCodigo("3459");
        voo.setSituacao(situacao);
        voo.setEmpresa(empresa);
        vooService.save(voo);
        List<Voo> all = vooService.getAll();
        int estadoInicial = all.size();
        Voo voo2 = all.getFirst();
        vooRepository.deleteById(voo2.getId());
        all = vooService.getAll();
        int estadoFinal = all.size();
        assertEquals(estadoInicial - 1, estadoFinal);
    }

    @Test
    @DisplayName("Deve retornar um voo através do Id")
    public void testFindById(){
        /*Situacao situacao = Situacao.builder().id(1L).build();
        Empresa empresa = Empresa.builder().id(1L).build();
        Voo voo = new Voo();
        voo.setCodigo("3459");
        voo.setSituacao(situacao);
        voo.setEmpresa(empresa);
        vooService.save(voo);
        List<Voo> all = vooService.getAll();
        Voo voo2 = all.get(0);
        Optional<Voo> byId = vooService.getById(voo2.getId());
        assertTrue(byId.isPresent());
        Optional<Voo> vooInexistente = vooService.getById(10);
        assertTrue(vooInexistente.isEmpty());*/
        Optional<Voo> voo = vooService.getById(1L);
        log.info("Voo: " + voo);
    }

}
