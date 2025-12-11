package mx.ipn.escom.enfermeria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.ipn.escom.enfermeria.entity.Movimiento;
import mx.ipn.escom.enfermeria.service.MovimientoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/movimientos")
@Tag(name = "Movimientos", description = "API para registro de movimientos de inventario")
public class MovimientoController {

    private final MovimientoService service;

    public MovimientoController(MovimientoService service) {
        this.service = service;
    }

    @Operation(summary = "Listar todos los movimientos")
    @GetMapping
    public List<Movimiento> listar() {
        return service.listarTodos();
    }

    @Operation(summary = "Obtener un movimiento por id")
    @GetMapping("/{id}")
    public ResponseEntity<Movimiento> obtener(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Registrar un nuevo movimiento")
    @PostMapping
    public ResponseEntity<Movimiento> crear(@RequestBody Movimiento movimiento) {
        return ResponseEntity.ok(service.crear(movimiento));
    }

    @Operation(summary = "Actualizar un movimiento")
    @PutMapping("/{id}")
    public ResponseEntity<Movimiento> actualizar(@PathVariable Long id,
                                                 @RequestBody Movimiento datos) {
        return service.actualizar(id, datos)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Eliminar un movimiento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminar(@PathVariable Long id) {
        boolean eliminado = service.eliminar(id);
        if (!eliminado) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
