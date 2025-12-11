package mx.ipn.escom.enfermeria.service;

import mx.ipn.escom.enfermeria.entity.Receta;
import mx.ipn.escom.enfermeria.repository.RecetaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RecetaService {

    private final RecetaRepository repo;

    public RecetaService(RecetaRepository repo) {
        this.repo = repo;
    }

    public List<Receta> listarTodos() {
        return repo.findAll();
    }

    public Optional<Receta> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Receta crear(Receta receta) {
        return repo.save(receta);
    }

    public Optional<Receta> actualizar(Long id, Receta datos) {
        return repo.findById(id).map(r -> {
            r.setFechaReceta(datos.getFechaReceta());
            r.setPacienteReceta(datos.getPacienteReceta());
            r.setDiagReceta(datos.getDiagReceta());
            r.setObserReceta(datos.getObserReceta());
            r.setIdUsuario(datos.getIdUsuario());
            return repo.save(r);
        });
    }

    public boolean eliminar(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
