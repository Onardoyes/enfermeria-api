package mx.ipn.escom.enfermeria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.ipn.escom.enfermeria.entity.Material;
import mx.ipn.escom.enfermeria.service.MaterialService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/materiales")
@Tag(name = "Materiales", description = "API para gestión de materiales médicos")
public class MaterialController {

    private final MaterialService service;

    public MaterialController(MaterialService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos los materiales")
    @GetMapping
    public List<Material> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Obtener un material por id")
    @GetMapping("/{id}")
    public ResponseEntity<Material> obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo material")
    @PostMapping
    public ResponseEntity<Material> crear(@RequestBody Material material) {
        return ResponseEntity.ok(service.crear(material));
    }

    @Operation(summary = "Actualizar un material")
    @PutMapping("/{id}")
    public ResponseEntity<Material> actualizar(@PathVariable Long id,
                                               @RequestBody Material datos) {
        return service.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un material")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = service.eliminar(id);
        if (!eliminado) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
