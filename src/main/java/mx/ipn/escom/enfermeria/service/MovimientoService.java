package mx.ipn.escom.enfermeria.service;

import mx.ipn.escom.enfermeria.entity.Movimiento;
import mx.ipn.escom.enfermeria.repository.MovimientoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovimientoService {

    private final MovimientoRepository repo;

    public MovimientoService(MovimientoRepository repo) {
        this.repo = repo;
    }

    public List<Movimiento> listarTodos() {
        return repo.findAll();
    }

    public Optional<Movimiento> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Movimiento crear(Movimiento movimiento) {
        return repo.save(movimiento);
    }

    public Optional<Movimiento> actualizar(Long id, Movimiento datos) {
        return repo.findById(id).map(m -> {
            m.setTipoMov(datos.getTipoMov());
            m.setFechaMov(datos.getFechaMov());
            m.setCantMov(datos.getCantMov());
            m.setMotivoMov(datos.getMotivoMov());
            m.setIdUsuario(datos.getIdUsuario());
            return repo.save(m);
        });
    }

    public boolean eliminar(Long id) {
        if (!repo.existsById(id)) return false;
        repo.deleteById(id);
        return true;
    }
}
