package mx.ipn.escom.enfermeria.repository;

import mx.ipn.escom.enfermeria.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findByCorreoUsuario(String correoUsuario);
}
