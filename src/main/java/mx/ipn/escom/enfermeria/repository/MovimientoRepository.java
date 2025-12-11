package mx.ipn.escom.enfermeria.repository;

import mx.ipn.escom.enfermeria.entity.Movimiento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovimientoRepository extends JpaRepository<Movimiento, Long> {
}
