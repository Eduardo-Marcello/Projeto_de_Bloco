package br.com.marcello.airlineticket.repository;

import br.com.marcello.airlineticket.model.Role;
import br.com.marcello.airlineticket.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    @Query("SELECT u FROM Usuario u where u.status = 1")
    List<Usuario> findAllAtivos();

    @Query("SELECT u FROM Usuario u where u.status = 0")
    List<Usuario> findAllDesativados();

    @Query("select u from Usuario u where u.status IN :statusList")
    List<Usuario> findAllByStatusIn(@Param("statusList") List<Integer> status);

    @Query("SELECT u from Usuario u inner join u.roles roles where roles in :roles")
    List<Usuario> findAllByRoles(@Param("rolesList") List<Role> roles);
}
