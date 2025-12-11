package mx.ipn.escom.enfermeria.service;

import mx.ipn.escom.enfermeria.entity.Medicamento;
import mx.ipn.escom.enfermeria.repository.MedicamentoRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MedicamentoService {

    private final MedicamentoRepository repo;

    public MedicamentoService(MedicamentoRepository repo) {
        this.repo = repo;
    }

    public List<Medicamento> listarTodos() {
        return repo.findAll();
    }

    public Optional<Medicamento> buscarPorId(Long id) {
        return repo.findById(id);
    }

    public Medicamento crear(Medicamento medicamento) {
        return repo.save(medicamento);
    }

    public Optional<Medicamento> actualizar(Long id, Medicamento datos) {
        return repo.findById(id).map(m -> {
            m.setNomMedi(datos.getNomMedi());
            m.setFechaCompraMedi(datos.getFechaCompraMedi());
            m.setFechaCadMedi(datos.getFechaCadMedi());
            m.setEstadoMedi(datos.getEstadoMedi());
            m.setStockMedi(datos.getStockMedi());
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
