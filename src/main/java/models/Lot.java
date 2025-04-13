package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "lot")
public class Lot {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "lot_id_gen")
    @SequenceGenerator(name = "lot_id_gen", sequenceName = "lot_idlot_seq", allocationSize = 1)
    @Column(name = "idlot", nullable = false)
    private Integer id;

    @Size(max = 254)
    @Column(name = "codeqr", length = 254)
    private String codeqr;

    @Size(max = 254)
    @Column(name = "libelle", length = 254)
    private String libelle;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @OneToMany(mappedBy = "idlot")
    private Set<models.Referencearticle> referencearticles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idlot")
    private Set<models.Stock> stocks = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCodeqr() {
        return codeqr;
    }

    public void setCodeqr(String codeqr) {
        this.codeqr = codeqr;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
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

    public Set<models.Referencearticle> getReferencearticles() {
        return referencearticles;
    }

    public void setReferencearticles(Set<models.Referencearticle> referencearticles) {
        this.referencearticles = referencearticles;
    }

    public Set<models.Stock> getStocks() {
        return stocks;
    }

    public void setStocks(Set<models.Stock> stocks) {
        this.stocks = stocks;
    }

}