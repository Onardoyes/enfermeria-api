package mx.ipn.escom.enfermeria.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "receta")
public class Receta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idReceta;

    private LocalDateTime fechaReceta;

    @Column(length = 45)
    private String pacienteReceta;

    @Column(length = 45)
    private String diagReceta;

    @Column(length = 100)
    private String obserReceta;

    // Usuario que genera la receta (solo guardamos el id)
    private Long idUsuario;

    public Receta() {
    }

    public Long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }

    public LocalDateTime getFechaReceta() {
        return fechaReceta;
    }

    public void setFechaReceta(LocalDateTime fechaReceta) {
        this.fechaReceta = fechaReceta;
    }

    public String getPacienteReceta() {
        return pacienteReceta;
    }

    public void setPacienteReceta(String pacienteReceta) {
        this.pacienteReceta = pacienteReceta;
    }

    public String getDiagReceta() {
        return diagReceta;
    }

    public void setDiagReceta(String diagReceta) {
        this.diagReceta = diagReceta;
    }

    public String getObserReceta() {
        return obserReceta;
    }

    public void setObserReceta(String obserReceta) {
        this.obserReceta = obserReceta;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
