package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "famille")
public class Famille {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "famille_id_gen")
    @SequenceGenerator(name = "famille_id_gen", sequenceName = "famille_idfamille_seq", allocationSize = 1)
    @Column(name = "idfamille", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idcatalogue")
    private Catalogue idcatalogue;

    @Size(max = 254)
    @Column(name = "reference", length = 254)
    private String reference;

    @Size(max = 254)
    @Column(name = "label", length = 254)
    private String label;

    @Size(max = 254)
    @Column(name = "description", length = 254)
    private String description;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @OneToMany(mappedBy = "idfamille")
    private Set<models.Produit> produits = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Catalogue getIdcatalogue() {
        return idcatalogue;
    }

    public void setIdcatalogue(Catalogue idcatalogue) {
        this.idcatalogue = idcatalogue;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public Set<models.Produit> getProduits() {
        return produits;
    }

    public void setProduits(Set<models.Produit> produits) {
        this.produits = produits;
    }

}