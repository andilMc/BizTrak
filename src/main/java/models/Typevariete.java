package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "typevariete")
public class Typevariete {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "typevariete_id_gen")
    @SequenceGenerator(name = "typevariete_id_gen", sequenceName = "typevariete_idtypevarite_seq", allocationSize = 1)
    @Column(name = "idtypevarite", nullable = false)
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

    @OneToMany(mappedBy = "idtypevarite")
    private Set<models.Variete> varietes = new LinkedHashSet<>();

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

    public Set<models.Variete> getVarietes() {
        return varietes;
    }

    public void setVarietes(Set<models.Variete> varietes) {
        this.varietes = varietes;
    }

}