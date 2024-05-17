package br.com.marcello.airlineticket.controller;

import br.com.marcello.airlineticket.model.Voo;
import br.com.marcello.airlineticket.service.VooService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/voo")
public class VooController {


    final VooService vooService;

    public VooController(VooService vooService) {
        this.vooService = vooService;
    }

    @GetMapping("/voos")
    public ResponseEntity<List<Voo>> getAll(@RequestParam(required = false) Optional<String> codigo){
        if(codigo.isEmpty()){
            return ResponseEntity.ok(vooService.getAll());
        } else {
            List<Voo> voos = vooService.getByCod(codigo.get());
            if(voos.isEmpty()){
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(voos);
            }
        }

    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Voo> getById(@PathVariable int id){
        try {
            return ResponseEntity.ok(vooService.getById(id));
        }catch (IllegalArgumentException | IndexOutOfBoundsException ex){
            return ResponseEntity.notFound().build();
        }
    }

    /* @GetMapping("/codigo/{codigo}")
    public ResponseEntity<Voo> getByCod(@PathVariable String codigo){
        try {
            return ResponseEntity.ok(vooService.getByCod(codigo));
        } catch (IllegalArgumentException | IndexOutOfBoundsException ex){
            return ResponseEntity.notFound().build();
        }
    } */

    @PostMapping("/save")
    public void save(@RequestBody Voo voo){
        vooService.save(voo);

    }

    @PutMapping("/update")
    public void update(@RequestBody Voo voo){
        System.out.println("Atualizando o voo");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Voo> deleteById(@PathVariable int id){
        try {
            return ResponseEntity.ok(vooService.deleteById(id));
        }catch (IllegalArgumentException | IndexOutOfBoundsException ex) {
            return ResponseEntity.notFound().build();
        }
    }
}
