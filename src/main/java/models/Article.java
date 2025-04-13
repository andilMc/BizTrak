package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "article")
public class Article {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "article_id_gen")
    @SequenceGenerator(name = "article_id_gen", sequenceName = "article_idarticle_seq", allocationSize = 1)
    @Column(name = "idarticle", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idproduit")
    private models.Produit idproduit;

    @Size(max = 254)
    @Column(name = "codeqr", length = 254)
    private String codeqr;

    @Column(name = "quantite")
    private BigDecimal quantite;

    @Column(name = "prix")
    private BigDecimal prix;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "dateexpiration")
    private LocalDate dateexpiration;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @OneToMany(mappedBy = "idarticle")
    private Set<models.Referencearticle> referencearticles = new LinkedHashSet<>();

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

    public String getCodeqr() {
        return codeqr;
    }

    public void setCodeqr(String codeqr) {
        this.codeqr = codeqr;
    }

    public BigDecimal getQuantite() {
        return quantite;
    }

    public void setQuantite(BigDecimal quantite) {
        this.quantite = quantite;
    }

    public BigDecimal getPrix() {
        return prix;
    }

    public void setPrix(BigDecimal prix) {
        this.prix = prix;
    }

    public Boolean getStatut() {
        return statut;
    }

    public void setStatut(Boolean statut) {
        this.statut = statut;
    }

    public LocalDate getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(LocalDate dateexpiration) {
        this.dateexpiration = dateexpiration;
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

}