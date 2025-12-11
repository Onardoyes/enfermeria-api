package mx.ipn.escom.enfermeria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.ipn.escom.enfermeria.service.ReporteService;
import org.springframework.http.ContentDisposition;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/reportes")
@Tag(name = "Reportes", description = "API para generación de reportes en PDF")
public class ReporteController {

    private final ReporteService reporteService;

    public ReporteController(ReporteService reporteService) {
        this.reporteService = reporteService;
    }

    @Operation(summary = "Generar reporte PDF de inventario")
    @GetMapping("/inventario/pdf")
    public ResponseEntity<byte[]> generarReporteInventario() {
        byte[] pdf = reporteService.generarReporteInventario();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_PDF);
        headers.setContentDisposition(
                ContentDisposition.attachment().filename("reporte-inventario.pdf").build()
        );

        return new ResponseEntity<>(pdf, headers, HttpStatus.OK);
    }
}
