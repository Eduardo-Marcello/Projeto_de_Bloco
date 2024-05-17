package br.com.marcello.airlineticket.controller;

import br.com.marcello.airlineticket.model.Voo;
import org.springframework.web.bind.annotation.*;


import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/voo")
public class VooController {

    static List<Voo> voos = initValues();

    private static List<Voo> initValues() {
        List<Voo> voos = new ArrayList<>();
        voos.add(new Voo(1, "3456", "Azul", "Bahia", "adiado",
                LocalDateTime.of(2024, 6, 20, 7, 30),
                LocalDateTime.of(2024, 6, 20, 10, 20)));
        voos.add(new Voo(2, "3457", "GO", "Recife", "normal",
                LocalDateTime.of(2024, 7, 5, 7, 30),
                LocalDateTime.of(2024, 7, 5, 11, 30)));

        return voos;
    }



    @GetMapping("/voos")
    public List<Voo> getAll(){
        System.out.println("Listando todos os voos");
        return voos;
    }

    @GetMapping("/{codigo}")
    public Voo getVooByCod(@PathVariable String codigo){
            for(Voo voo : getAll()){
                if(voo.getCodigo().equals(codigo)){
                    return voo;
                }
            }

            return null;
    }

    @PostMapping("/save")
    public void save(@RequestBody Voo voo){
        voos.add(voo);
        System.out.println(voo);
        System.out.println("Cadastrando o voo");
    }

    @PutMapping("/update")
    public void update(){
        System.out.println("Atualizando o voo");
    }

    @DeleteMapping("/delete")
    public void delete(){
        System.out.println("Deletando o voo");
    }
}
