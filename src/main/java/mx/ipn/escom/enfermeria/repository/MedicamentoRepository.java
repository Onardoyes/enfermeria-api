package mx.ipn.escom.enfermeria.repository;

import mx.ipn.escom.enfermeria.entity.Medicamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicamentoRepository extends JpaRepository<Medicamento, Long> {
}
