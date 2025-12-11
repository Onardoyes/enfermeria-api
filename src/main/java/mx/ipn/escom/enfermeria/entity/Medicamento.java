package mx.ipn.escom.enfermeria.entity;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name = "medicamento")
public class Medicamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMedicamento;

    @Column(length = 45)
    private String nomMedi;

    private LocalDate fechaCompraMedi;
    private LocalDate fechaCadMedi;

    @Column(length = 45)
    private String estadoMedi;

    @Column(length = 45)
    private String stockMedi;   // si quieres luego lo cambias a Integer

    // Relaciones por ID (no usamos @ManyToOne para que sea simple)
    private Long idReceta;
    private Long idMovimiento;
    private Long idCategoria;

    public Medicamento() {
    }

    public Long getIdMedicamento() {
        return idMedicamento;
    }

    public void setIdMedicamento(Long idMedicamento) {
        this.idMedicamento = idMedicamento;
    }

    public String getNomMedi() {
        return nomMedi;
    }

    public void setNomMedi(String nomMedi) {
        this.nomMedi = nomMedi;
    }

    public LocalDate getFechaCompraMedi() {
        return fechaCompraMedi;
    }

    public void setFechaCompraMedi(LocalDate fechaCompraMedi) {
        this.fechaCompraMedi = fechaCompraMedi;
    }

    public LocalDate getFechaCadMedi() {
        return fechaCadMedi;
    }

    public void setFechaCadMedi(LocalDate fechaCadMedi) {
        this.fechaCadMedi = fechaCadMedi;
    }

    public String getEstadoMedi() {
        return estadoMedi;
    }

    public void setEstadoMedi(String estadoMedi) {
        this.estadoMedi = estadoMedi;
    }

    public String getStockMedi() {
        return stockMedi;
    }

    public void setStockMedi(String stockMedi) {
        this.stockMedi = stockMedi;
    }

    public Long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }

    public Long getIdMovimiento() {
        return idMovimiento;
    }

    public void setIdMovimiento(Long idMovimiento) {
        this.idMovimiento = idMovimiento;
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }
}
