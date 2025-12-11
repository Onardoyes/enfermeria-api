package mx.ipn.escom.enfermeria.service;

import mx.ipn.escom.enfermeria.entity.DetalleReceta;
import mx.ipn.escom.enfermeria.repository.DetalleRecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DetalleRecetaService {

    @Autowired
    private DetalleRecetaRepository repo;

    public List<DetalleReceta> listarTodos() {
        return repo.findAll();
    }

    public Optional<DetalleReceta> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public DetalleReceta guardar(DetalleReceta detalle) {
        return repo.save(detalle);
    }

    public Optional<DetalleReceta> actualizar(Long id, DetalleReceta datos) {
        return repo.findById(id).map(d -> {
            d.setCantReceta(datos.getCantReceta());
            d.setDosisReceta(datos.getDosisReceta());
            d.setDuracion(datos.getDuracion());
            d.setIdReceta(datos.getIdReceta());
            return repo.save(d);
        });
    }

    public boolean eliminar(Long id) {
        if (!repo.existsById(id)) {
            return false;
        }
        repo.deleteById(id);
        return true;
    }
}
