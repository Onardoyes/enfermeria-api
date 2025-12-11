package mx.ipn.escom.enfermeria.repository;

import mx.ipn.escom.enfermeria.entity.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
