package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "image_id_gen")
    @SequenceGenerator(name = "image_id_gen", sequenceName = "image_idimage_seq", allocationSize = 1)
    @Column(name = "idimage", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproduit")
    private models.Produit idproduit;

    @Size(max = 254)
    @Column(name = "pathimage", length = 254)
    private String pathimage;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @Column(name = "datemodification")
    private LocalDate datemodification;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public models.Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(models.Produit idproduit) {
        this.idproduit = idproduit;
    }

    public String getPathimage() {
        return pathimage;
    }

    public void setPathimage(String pathimage) {
        this.pathimage = pathimage;
    }

    public LocalDate getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

    public LocalDate getDatemodification() {
        return datemodification;
    }

    public void setDatemodification(LocalDate datemodification) {
        this.datemodification = datemodification;
    }

}