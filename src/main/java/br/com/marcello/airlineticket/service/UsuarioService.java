package br.com.marcello.airlineticket.service;

import br.com.marcello.airlineticket.model.Role;
import br.com.marcello.airlineticket.model.Usuario;

import java.util.List;

public interface UsuarioService {
    List<Usuario> findAll();
    List<Usuario> findAllUsuariosAtivos();
    List<Usuario> findAllUsuariosDesativados();
    List<Usuario> findAllByStatusList(List<Integer> status);
    List<Usuario> findAllByRoles(List<Role> roles);
}
