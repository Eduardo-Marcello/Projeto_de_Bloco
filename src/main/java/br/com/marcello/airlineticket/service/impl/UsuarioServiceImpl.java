package br.com.marcello.airlineticket.service.impl;

import br.com.marcello.airlineticket.model.Role;
import br.com.marcello.airlineticket.model.Usuario;
import br.com.marcello.airlineticket.repository.UsuarioRepository;
import br.com.marcello.airlineticket.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UsuarioServiceImpl implements UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Override
    public List<Usuario> findAll() {
        return usuarioRepository.findAll();
    }

    @Override
    public List<Usuario> findAllUsuariosAtivos() {
        List<Usuario> allAtivos = usuarioRepository.findAllAtivos();
        return allAtivos;
    }

    @Override
    public List<Usuario> findAllUsuariosDesativados() {
        List<Usuario> allDesativados = usuarioRepository.findAllDesativados();
        return allDesativados;
    }

    @Override
    public List<Usuario> findAllByStatusList(List<Integer> status) {
        return usuarioRepository.findAllByStatusIn(status);
    }

    @Override
    public List<Usuario> findAllByRoles(List<Role> roles) {
        return usuarioRepository.findAllByRoles(roles);
    }
}
