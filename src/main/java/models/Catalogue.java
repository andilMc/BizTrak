package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "catalogue")
public class Catalogue {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "catalogue_id_gen")
    @SequenceGenerator(name = "catalogue_id_gen", sequenceName = "catalogue_idcatalogue_seq", allocationSize = 1)
    @Column(name = "idcatalogue", nullable = false)
    private Integer id;

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

    @OneToMany(mappedBy = "idcatalogue")
    private Set<models.Famille> familles = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Set<models.Famille> getFamilles() {
        return familles;
    }

    public void setFamilles(Set<models.Famille> familles) {
        this.familles = familles;
    }

}