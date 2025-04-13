package models;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "produit_id_gen")
    @SequenceGenerator(name = "produit_id_gen", sequenceName = "produit_idproduit_seq", allocationSize = 1)
    @Column(name = "idproduit", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idfamille")
    private Famille idfamille;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idunitemesure")
    private models.Unitemesure idunitemesure;

    @Size(max = 254)
    @Column(name = "codeqr", length = 254)
    private String codeqr;

    @Size(max = 254)
    @Column(name = "designation", length = 254)
    private String designation;

    @Size(max = 254)
    @Column(name = "description", length = 254)
    private String description;

    @Column(name = "prixunite")
    private BigDecimal prixunite;

    @Column(name = "seuilalerte")
    private BigDecimal seuilalerte;

    @Column(name = "statut")
    private Boolean statut;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @OneToMany(mappedBy = "idproduit")
    private Set<Article> articles = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idproduit")
    private Set<Detailsproduit> detailsproduits = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idproduit")
    private Set<Image> images = new LinkedHashSet<>();

    @OneToMany(mappedBy = "idproduit")
    private Set<models.Variete> varietes = new LinkedHashSet<>();

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Famille getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(Famille idfamille) {
        this.idfamille = idfamille;
    }

    public models.Unitemesure getIdunitemesure() {
        return idunitemesure;
    }

    public void setIdunitemesure(models.Unitemesure idunitemesure) {
        this.idunitemesure = idunitemesure;
    }

    public String getCodeqr() {
        return codeqr;
    }

    public void setCodeqr(String codeqr) {
        this.codeqr = codeqr;
    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrixunite() {
        return prixunite;
    }

    public void setPrixunite(BigDecimal prixunite) {
        this.prixunite = prixunite;
    }

    public BigDecimal getSeuilalerte() {
        return seuilalerte;
    }

    public void setSeuilalerte(BigDecimal seuilalerte) {
        this.seuilalerte = seuilalerte;
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

    public Set<Article> getArticles() {
        return articles;
    }

    public void setArticles(Set<Article> articles) {
        this.articles = articles;
    }

    public Set<Detailsproduit> getDetailsproduits() {
        return detailsproduits;
    }

    public void setDetailsproduits(Set<Detailsproduit> detailsproduits) {
        this.detailsproduits = detailsproduits;
    }

    public Set<Image> getImages() {
        return images;
    }

    public void setImages(Set<Image> images) {
        this.images = images;
    }

    public Set<models.Variete> getVarietes() {
        return varietes;
    }

    public void setVarietes(Set<models.Variete> varietes) {
        this.varietes = varietes;
    }

}