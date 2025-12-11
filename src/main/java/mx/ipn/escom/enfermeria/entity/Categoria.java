package mx.ipn.escom.enfermeria.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCategoria;

    @Column(length = 45)
    private String nomCategoria;

    @Column(length = 100)
    private String descriCategoria;

    public Categoria() {
    }

    public Long getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(Long idCategoria) {
        this.idCategoria = idCategoria;
    }

    public String getNomCategoria() {
        return nomCategoria;
    }

    public void setNomCategoria(String nomCategoria) {
        this.nomCategoria = nomCategoria;
    }

    public String getDescriCategoria() {
        return descriCategoria;
    }

    public void setDescriCategoria(String descriCategoria) {
        this.descriCategoria = descriCategoria;
    }
}
