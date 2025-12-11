package mx.ipn.escom.enfermeria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "material")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idMaterial;

    @Column(length = 45)
    private String nomMaterial;

    @Column(length = 45)
    private String fechaCompraMaterial;

    @Column(length = 45)
    private String stockMaterial;

    @Column(length = 45)
    private String estadoMaterial;

    private Long idReceta;
    private Long idMovimiento;
    private Long idCategoria;

    public Material() {
    }

    public Long getIdMaterial() {
        return idMaterial;
    }

    public void setIdMaterial(Long idMaterial) {
        this.idMaterial = idMaterial;
    }

    public String getNomMaterial() {
        return nomMaterial;
    }

    public void setNomMaterial(String nomMaterial) {
        this.nomMaterial = nomMaterial;
    }

    public String getFechaCompraMaterial() {
        return fechaCompraMaterial;
    }

    public void setFechaCompraMaterial(String fechaCompraMaterial) {
        this.fechaCompraMaterial = fechaCompraMaterial;
    }

    public String getStockMaterial() {
        return stockMaterial;
    }

    public void setStockMaterial(String stockMaterial) {
        this.stockMaterial = stockMaterial;
    }

    public String getEstadoMaterial() {
        return estadoMaterial;
    }

    public void setEstadoMaterial(String estadoMaterial) {
        this.estadoMaterial = estadoMaterial;
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
