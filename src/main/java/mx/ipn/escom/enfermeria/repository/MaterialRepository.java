package mx.ipn.escom.enfermeria.repository;

import mx.ipn.escom.enfermeria.entity.Material;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaterialRepository extends JpaRepository<Material, Long> {
}
