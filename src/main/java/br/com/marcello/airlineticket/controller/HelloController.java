package br.com.marcello.airlineticket.controller;

import br.com.marcello.airlineticket.model.Voo;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping("/voos")
public class HelloController {
    @GetMapping
    public List<Voo> voos(){
        System.out.println("Ola");

        Voo voo1 = new Voo();
        voo1.setId(1);
        voo1.setCodigo("3456");
        voo1.setEmpresa("Azul");
        voo1.setDestino("Bahia");

        Voo voo2 = new Voo();
        voo2.setId(2);
        voo2.setCodigo("3457");
        voo2.setEmpresa("GO");
        voo2.setDestino("Recife");

        List<Voo> voos = List.of(voo1, voo2);

        return voos;
    }

}
