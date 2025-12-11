package mx.ipn.escom.enfermeria.service;

import mx.ipn.escom.enfermeria.entity.Material;
import mx.ipn.escom.enfermeria.repository.MaterialRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MaterialService {

    private final MaterialRepository repo;

    public MaterialService(MaterialRepository repo) {
        this.repo = repo;
    }

    public List<Material> listarTodos() {
        return repo.findAll();
    }

    public Optional<Material> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Material crear(Material material) {
        return repo.save(material);
    }

    public Optional<Material> actualizar(Long id, Material datos) {
        return repo.findById(id).map(m -> {
            m.setNomMaterial(datos.getNomMaterial());
            m.setFechaCompraMaterial(datos.getFechaCompraMaterial());
            m.setStockMaterial(datos.getStockMaterial());
            m.setEstadoMaterial(datos.getEstadoMaterial());
            m.setIdReceta(datos.getIdReceta());
            m.setIdMovimiento(datos.getIdMovimiento());
            m.setIdCategoria(datos.getIdCategoria());
            return repo.save(m);
        });
    }

    public boolean eliminar(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
