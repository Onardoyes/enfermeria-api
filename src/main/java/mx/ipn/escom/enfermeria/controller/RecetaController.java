package mx.ipn.escom.enfermeria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.ipn.escom.enfermeria.entity.Receta;
import mx.ipn.escom.enfermeria.service.RecetaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/recetas")
@Tag(name = "Recetas", description = "API para gestión de recetas médicas")
public class RecetaController {

    private final RecetaService service;

    public RecetaController(RecetaService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todas las recetas")
    @GetMapping
    public List<Receta> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Obtener una receta por id")
    @GetMapping("/{id}")
    public ResponseEntity<Receta> obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear una nueva receta")
    @PostMapping
    public ResponseEntity<Receta> crear(@RequestBody Receta receta) {
        return ResponseEntity.ok(service.crear(receta));
    }

    @Operation(summary = "Actualizar una receta")
    @PutMapping("/{id}")
    public ResponseEntity<Receta> actualizar(@PathVariable Long id,
                                             @RequestBody Receta datos) {
        return service.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar una receta")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = service.eliminar(id);
        if (!eliminado) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
