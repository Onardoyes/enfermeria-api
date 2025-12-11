package mx.ipn.escom.enfermeria.controller;

import mx.ipn.escom.enfermeria.entity.DetalleReceta;
import mx.ipn.escom.enfermeria.service.DetalleRecetaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/detallerecetas")
@Tag(
        name = "DetalleReceta",
        description = "API para gestionar los detalles de las recetas médicas"
)
public class DetalleRecetaController {

    @Autowired
    private DetalleRecetaService service;

    @GetMapping
    @Operation(
            summary = "Listar todos los detalles de receta",
            description = "Devuelve la lista completa de detalles de receta registrados"
    )
    public ResponseEntity<List<DetalleReceta>> listar() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    @Operation(
            summary = "Buscar detalle de receta por id",
            description = "Devuelve un detalle de receta específico según su identificador"
    )
    public ResponseEntity<DetalleReceta> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    @Operation(
            summary = "Crear un nuevo detalle de receta",
            description = "Registra un nuevo detalle de receta asociado a una receta"
    )
    public ResponseEntity<DetalleReceta> crear(@RequestBody DetalleReceta detalle) {
        DetalleReceta guardado = service.guardar(detalle);
        return ResponseEntity.ok(guardado);
    }

    @PutMapping("/{id}")
    @Operation(
            summary = "Actualizar un detalle de receta",
            description = "Actualiza la información de un detalle de receta existente"
    )
    public ResponseEntity<DetalleReceta> actualizar(
            @PathVariable Long id,
            @RequestBody DetalleReceta detalle
    ) {
        return service.actualizar(id, detalle)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    @Operation(
            summary = "Eliminar un detalle de receta",
            description = "Elimina un detalle de receta por su identificador"
    )
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        if (service.eliminar(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
