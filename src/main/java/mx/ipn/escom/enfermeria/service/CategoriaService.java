package mx.ipn.escom.enfermeria.service;

import mx.ipn.escom.enfermeria.entity.Categoria;
import mx.ipn.escom.enfermeria.repository.CategoriaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    private final CategoriaRepository repo;

    public CategoriaService(CategoriaRepository repo) {
        this.repo = repo;
    }

    public List<Categoria> listarTodos() {
        return repo.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Categoria crear(Categoria categoria) {
        return repo.save(categoria);
    }

    public Optional<Categoria> actualizar(Long id, Categoria datos) {
        return repo.findById(id).map(c -> {
            c.setNomCategoria(datos.getNomCategoria());
            c.setDescriCategoria(datos.getDescriCategoria());
            return repo.save(c);
        });
    }

    public boolean eliminar(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
