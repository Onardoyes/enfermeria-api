package mx.ipn.escom.enfermeria.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import mx.ipn.escom.enfermeria.dto.EmailRequest;
import mx.ipn.escom.enfermeria.service.EmailService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/notificaciones")
@Tag(name = "Notificaciones", description = "API para envío de correos electrónicos")
public class EmailController {

    private final EmailService emailService;

    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @Operation(summary = "Enviar correo simple")
    @PostMapping("/correo")
    public ResponseEntity<String> enviarCorreo(@RequestBody EmailRequest request) {
        emailService.enviarCorreo(request.getPara(),
                request.getAsunto(),
                request.getMensaje());
        return ResponseEntity.ok("Correo enviado correctamente");
    }
}
