package models.DTO;

import jakarta.inject.Named;
import models.Famille;
import models.Unitemesure;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link models.Produit}
 */
@Named
public class ProduitDto implements Serializable {
    private  int id;
    private  Famille idfamille;
    private Unitemesure idunitemesure;
    @Size(max = 254)
    private  String codeqr;
    @Size(max = 254)
    private  String designation;
    @Size(max = 254)
    private  String description;
    private  BigDecimal prixunite;
    private  BigDecimal seuilalerte;
    private  Boolean statut;
    private  LocalDate datecreation;

public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Famille getIdfamille() {
        return idfamille;
    }

    public void setIdfamille(Famille idfamille) {
        this.idfamille = idfamille;
    }

    public Unitemesure getIdunitemesure() {
        return idunitemesure;
    }

    public void setIdunitemesure(Unitemesure idunitemesure) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ProduitDto entity = (ProduitDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idfamille, entity.idfamille) &&
                Objects.equals(this.idunitemesure, entity.idunitemesure) &&
                Objects.equals(this.codeqr, entity.codeqr) &&
                Objects.equals(this.designation, entity.designation) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.prixunite, entity.prixunite) &&
                Objects.equals(this.seuilalerte, entity.seuilalerte) &&
                Objects.equals(this.statut, entity.statut) &&
                Objects.equals(this.datecreation, entity.datecreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idfamille, idunitemesure, codeqr, designation, description, prixunite, seuilalerte, statut, datecreation);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idfamille = " + idfamille + ", " +
                "idunitemesure = " + idunitemesure + ", " +
                "codeqr = " + codeqr + ", " +
                "designation = " + designation + ", " +
                "description = " + description + ", " +
                "prixunite = " + prixunite + ", " +
                "seuilalerte = " + seuilalerte + ", " +
                "statut = " + statut + ", " +
                "datecreation = " + datecreation + ")";
    }
}