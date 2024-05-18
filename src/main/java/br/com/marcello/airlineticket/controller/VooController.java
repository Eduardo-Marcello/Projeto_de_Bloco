package br.com.marcello.airlineticket.controller;

import br.com.marcello.airlineticket.exception.ResourceNotFoundException;
import br.com.marcello.airlineticket.model.Voo;
import br.com.marcello.airlineticket.payload.MessagePayload;
import br.com.marcello.airlineticket.service.VooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/voo")
public class VooController {

    Logger logger = LoggerFactory.getLogger(VooController.class);
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
        }catch (ResourceNotFoundException ex){
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
       //VooService vooService = new VooService();
        vooService.save(voo);

    }

    @PutMapping("/update/{codigo}")
    public ResponseEntity<MessagePayload> update(@PathVariable String codigo, @RequestBody Voo voo){
        try {
            vooService.update(codigo, voo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload("Voo alterado com sucesso!"));
        } catch (ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessagePayload(ex.getMessage()));
        }
    }

    @DeleteMapping("/delete/{codigo}")
    public ResponseEntity<MessagePayload> deleteByCod(@PathVariable String codigo){
        try {
            vooService.deleteByCod(codigo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload("Voo deletado com sucesso!"));
        } catch (ResourceNotFoundException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessagePayload(ex.getMessage()));
        }
    }

}
