package br.com.marcello.airlineticket.service;

import br.com.marcello.airlineticket.exception.ResourceNotFoundException;
import br.com.marcello.airlineticket.model.Voo;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    private boolean resourceNotFound(String code){

        return voos.stream().filter(voo -> Objects.equals(voo.getCodigo(), code)).findFirst().isEmpty() &&
                !code.matches("[0-9]*") &&
                code.length() < 4;
    }

    private int findId(String codigo){
        int vooId = -1;
        for (int i = 0; i < voos.size(); i++) {
            if (voos.get(i).getCodigo().equals(codigo)) {
                vooId = i;
                break;
            }
        }
        return vooId;
    }
    

    public List<Voo> getAll() {
        return this.voos;
    }

    /* public boolean getId(int id) {
        if(id <= 0) {
            return false;
        } else {
            return true;
        }
    } */

    public Voo getById(int id) {
        if(id <= 0){
            throw new ResourceNotFoundException("Valor Inválido - Id inexistente!");
        } else {
            return this.voos.get(id-1);
        }

    }

    public List<Voo> getByCod(String codigo){
        System.out.println(resourceNotFound(codigo));
        if(resourceNotFound(codigo)){
            throw new ResourceNotFoundException("Valor Inválido - Codigo inexistente!");
        } else {
            return getAll().stream().filter(voo -> voo.getCodigo().startsWith(codigo)).toList();
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


    public void update(String codigo, Voo voo) {
        if(resourceNotFound(codigo)){
            throw new ResourceNotFoundException("Voo não encontrado!");
        } else {
            //int vooId = voos.indexOf(Objects.equals(voo.getCodigo(), codigo));
            voos.set(findId(codigo), voo);
        }
    }
    
    public void deleteByCod(String codigo) {
        if(resourceNotFound(codigo)){
            throw new ResourceNotFoundException("Voo não encontrado!");
        } else {
            voos.remove(voos.get(findId(codigo)));
            //voos.removeIf(voo -> Objects.equals(voo.getCodigo(), codigo));
        }

    }
}

