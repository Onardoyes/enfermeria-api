package mx.ipn.escom.enfermeria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "detallereceta")
public class DetalleReceta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idDetalleReceta;

    @Column(length = 45)
    private String cantReceta;     // Cantidad prescrita

    @Column(length = 70)
    private String dosisReceta;    // Dosis del medicamento

    @Column(length = 70)
    private String duracion;       // Duración del tratamiento

    // Relación con Receta (por simplicidad guardamos solo el id)
    private Long idReceta;

    public DetalleReceta() {
    }

    public Long getIdDetalleReceta() {
        return idDetalleReceta;
    }

    public void setIdDetalleReceta(Long idDetalleReceta) {
        this.idDetalleReceta = idDetalleReceta;
    }

    public String getCantReceta() {
        return cantReceta;
    }

    public void setCantReceta(String cantReceta) {
        this.cantReceta = cantReceta;
    }

    public String getDosisReceta() {
        return dosisReceta;
    }

    public void setDosisReceta(String dosisReceta) {
        this.dosisReceta = dosisReceta;
    }

    public String getDuracion() {
        return duracion;
    }

    public void setDuracion(String duracion) {
        this.duracion = duracion;
    }

    public Long getIdReceta() {
        return idReceta;
    }

    public void setIdReceta(Long idReceta) {
        this.idReceta = idReceta;
    }
}
