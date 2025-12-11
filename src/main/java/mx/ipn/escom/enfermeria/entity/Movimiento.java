package mx.ipn.escom.enfermeria.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "movimiento")
public class Movimiento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMovimiento;

    @Column(length = 45)
    private String tipoMov;   // Entrada / Salida

    private LocalDateTime fechaMov;

    @Column(length = 45)
    private String cantMov;

    @Column(length = 100)
    private String motivoMov;

    // Usuario que realiza el movimiento
    private Long idUsuario;

    public Movimiento() {
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public String getTipoMov() {
        return tipoMov;
    }

    public void setTipoMov(String tipoMov) {
        this.tipoMov = tipoMov;
    }

    public LocalDateTime getFechaMov() {
        return fechaMov;
    }

    public void setFechaMov(LocalDateTime fechaMov) {
        this.fechaMov = fechaMov;
    }

    public String getCantMov() {
        return cantMov;
    }

    public void setCantMov(String cantMov) {
        this.cantMov = cantMov;
    }

    public String getMotivoMov() {
        return motivoMov;
    }

    public void setMotivoMov(String motivoMov) {
        this.motivoMov = motivoMov;
    }

    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }
}
