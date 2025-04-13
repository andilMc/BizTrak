package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;

@Entity
@Table(name = "variete")
public class Variete {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "variete_id_gen")
    @SequenceGenerator(name = "variete_id_gen", sequenceName = "variete_idvariete_seq", allocationSize = 1)
    @Column(name = "idvariete", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idtypevarite")
    private Typevariete idtypevarite;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproduit")
    private Produit idproduit;

    @Size(max = 254)
    @Column(name = "valeur", length = 254)
    private String valeur;

    @Column(name = "satut")
    private Boolean satut;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Typevariete getIdtypevarite() {
        return idtypevarite;
    }

    public void setIdtypevarite(Typevariete idtypevarite) {
        this.idtypevarite = idtypevarite;
    }

    public Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Produit idproduit) {
        this.idproduit = idproduit;
    }

    public String getValeur() {
        return valeur;
    }

    public void setValeur(String valeur) {
        this.valeur = valeur;
    }

    public Boolean getSatut() {
        return satut;
    }

    public void setSatut(Boolean satut) {
        this.satut = satut;
    }

    public LocalDate getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

}