package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "detailsproduit")
public class Detailsproduit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "detailsproduit_id_gen")
    @SequenceGenerator(name = "detailsproduit_id_gen", sequenceName = "detailsproduit_iddetailsproduit_seq", allocationSize = 1)
    @Column(name = "iddetailsproduit", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproduit")
    private models.Produit idproduit;

    @Size(max = 254)
    @Column(name = "caracteristique", length = 254)
    private String caracteristique;

    @Size(max = 254)
    @Column(name = "valeur", length = 254)
    private String valeur;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "datecreation")
    private LocalDate datecreation;

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

    public String getCaracteristique() {
        return caracteristique;
    }

    public void setCaracteristique(String caracteristique) {
        this.caracteristique = caracteristique;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public LocalDate getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

}