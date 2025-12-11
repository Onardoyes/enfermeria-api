package mx.ipn.escom.enfermeria.service;

import mx.ipn.escom.enfermeria.entity.Usuario;
import mx.ipn.escom.enfermeria.repository.UsuarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UsuarioService {

    private final UsuarioRepository repo;

    public UsuarioService(UsuarioRepository repo) {
        this.repo = repo;
    }

    public List<Usuario> listarTodos() {
        return repo.findAll();
    }

    public Optional<Usuario> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Usuario crear(Usuario usuario) {
        return repo.save(usuario);
    }

    public Optional<Usuario> actualizar(Long id, Usuario datos) {
        return repo.findById(id).map(u -> {
            u.setNomUsuario(datos.getNomUsuario());
            u.setRolUsuario(datos.getRolUsuario());
            u.setCorreoUsuario(datos.getCorreoUsuario());
            u.setPasswordUsuario(datos.getPasswordUsuario());
            return repo.save(u);
        });
    }

    public boolean eliminar(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
