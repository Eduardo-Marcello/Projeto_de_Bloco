package br.com.marcello.airlineticket.controller;

import br.com.marcello.airlineticket.model.Situacao;
import br.com.marcello.airlineticket.model.Voo;
import br.com.marcello.airlineticket.payload.MessagePayload;
import br.com.marcello.airlineticket.repository.VooRepository;
import br.com.marcello.airlineticket.service.SituacaoService;
import br.com.marcello.airlineticket.service.VooService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.management.RuntimeErrorException;
import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/voo")
public class VooController {

    Logger logger = LoggerFactory.getLogger(VooController.class);
    final VooRepository vooRepository;
    final VooService vooService;
    final SituacaoService situacaoService;

    public VooController(VooRepository vooRepository, VooService vooService, SituacaoService situacaoService) {
        this.vooRepository = vooRepository;
        this.vooService = vooService;
        this.situacaoService = situacaoService;
    }



    @GetMapping("/voos")
    public ResponseEntity<List<Voo>> getAll(@RequestParam(required = false) Optional<String> codigo){
        if(codigo.isEmpty()){
            return ResponseEntity.ok(vooService.getAll());
        } else {
            List<Voo> voos = vooService.findbyCode(codigo.get());
            if(voos.isEmpty()){
                return ResponseEntity.notFound().build();
            } else {
                return ResponseEntity.ok(voos);
            }
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Long id){
        try {
            return ResponseEntity.ok(vooService.getById(id));
        }catch (RuntimeErrorException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @GetMapping("/natio")
    public ResponseEntity<?> getNationals(){
        try {
            return ResponseEntity.ok(vooService.findAllNationals());
        } catch (RuntimeErrorException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @GetMapping("/inter")
    public ResponseEntity<?> getInternationals(){
        try {
            return ResponseEntity.ok(vooService.findAllInternationals());
        } catch (RuntimeErrorException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    @GetMapping("/normal")
    public ResponseEntity<?> findAllStatusNormal(){
        try{
            List<Situacao> all = situacaoService.findAll();
            return ResponseEntity.ok(vooRepository.findAllStatusNormal(all));
        } catch (RuntimeException ex){
            return ResponseEntity.ok(ex.getMessage());
        }
    }

    //Com problema
    @PostMapping("/save")
    public void save(@RequestBody Voo voo){
        vooService.save(voo);
    }

    //Com problema
    @PutMapping("/update/{id}")
    public ResponseEntity<MessagePayload> update(@PathVariable Long id, @RequestBody Voo voo){
        try {
            vooService.update(id, voo);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload("Voo alterado com sucesso!"));
        } catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessagePayload(ex.getMessage()));
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<MessagePayload> deleteById(@PathVariable Long id){
        try {
            vooService.deleteById(id);
            return ResponseEntity.status(HttpStatus.ACCEPTED).body(new MessagePayload("Voo deletado com sucesso!"));
        } catch (RuntimeException ex){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new MessagePayload(ex.getMessage()));
        }
    }

}
