package br.com.marcello.airlineticket.service;

import br.com.marcello.airlineticket.model.Voo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class VooService {

     List<Voo> voos = initValues();

    private  List<Voo> initValues() {
        List<Voo> voos = new ArrayList<>();
        voos.add(new Voo(1, "3456", "Azul", "Bahia", "adiado",
                LocalDateTime.of(2024, 6, 20, 7, 30),
                LocalDateTime.of(2024, 6, 20, 10, 20)));
        voos.add(new Voo(2, "3457", "GO", "Recife", "normal",
                LocalDateTime.of(2024, 7, 5, 7, 30),
                LocalDateTime.of(2024, 7, 5, 11, 30)));

        return voos;
    }

    public List<Voo> getAll() {
        return this.voos;
    }

    public boolean getId(int id) {
        if(id <= 0) {
            return false;
        } else {
            return true;
        }
    }

    public Voo getById(int id) {
        if(!getId(id)){
            throw new IllegalArgumentException("Valor Inválido - Id inexistente!");
        } else {
            return this.voos.get(id-1);
        }

    }

    public List<Voo> getByCod(String codigo){
        if(!codigo.isEmpty() && codigo.matches("[0-9]*")){
            return getAll().stream().filter(voo -> voo.getCodigo().startsWith(codigo)).toList();
        } else {
            throw new IllegalArgumentException("Valor Inválido - Codigo inexistente!");
        }

        /*
        for(Voo voo : getAll()){
            if(voo.getCodigo().equals(codigo)){
                return voo;
            }
        }
        throw new IllegalArgumentException("Valor Inválido - Codigo inexistente!");
         */
    }

    public void save(Voo voo) {
        voos.add(voo);
    }

    public Voo deleteById(int id) {
        if(!getId(id)){
            throw new IllegalArgumentException("Valor Inválido - Id inexistente!");
        } else {
            return getAll().remove(id-1);
        }

    }
}

