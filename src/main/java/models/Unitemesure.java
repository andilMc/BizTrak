package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "unitemesure")
public class Unitemesure {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "unitemesure_id_gen")
    @SequenceGenerator(name = "unitemesure_id_gen", sequenceName = "unitemesure_idunitemesure_seq", allocationSize = 1)
    @Column(name = "idunitemesure", nullable = false)
    private Integer id;

    @Size(max = 254)
    @Column(name = "label", length = 254)
    private String label;

    @Size(max = 254)
    @Column(name = "typevaleur", length = 254)
    private String typevaleur;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @OneToMany(mappedBy = "idunitemesure")
    private Set<Produit> produits = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getTypevaleur() {
        return typevaleur;
    }

    public void setTypevaleur(String typevaleur) {
        this.typevaleur = typevaleur;
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

    public Set<Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<Produit> produits) {
        this.produits = produits;
    }

}