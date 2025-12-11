package mx.ipn.escom.enfermeria.repository;

import mx.ipn.escom.enfermeria.entity.DetalleReceta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DetalleRecetaRepository extends JpaRepository<DetalleReceta, Long> {
}
