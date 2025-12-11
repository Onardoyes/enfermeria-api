package mx.ipn.escom.enfermeria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.ipn.escom.enfermeria.entity.Medicamento;
import mx.ipn.escom.enfermeria.service.MedicamentoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/medicamentos")
@Tag(name = "Medicamentos", description = "API para gestión de medicamentos")
public class MedicamentoController {

    private final MedicamentoService service;

    public MedicamentoController(MedicamentoService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos los medicamentos")
    @GetMapping
    public List<Medicamento> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Obtener un medicamento por id")
    @GetMapping("/{id}")
    public ResponseEntity<Medicamento> obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear un nuevo medicamento")
    @PostMapping
    public ResponseEntity<Medicamento> crear(@RequestBody Medicamento medicamento) {
        return ResponseEntity.ok(service.crear(medicamento));
    }

    @Operation(summary = "Actualizar un medicamento")
    @PutMapping("/{id}")
    public ResponseEntity<Medicamento> actualizar(@PathVariable Long id,
                                                  @RequestBody Medicamento datos) {
        return service.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un medicamento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = service.eliminar(id);
        if (!eliminado) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
