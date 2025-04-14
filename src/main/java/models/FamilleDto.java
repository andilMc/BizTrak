package models;

import jakarta.inject.Named;
import models.DTO.CatalogueDto;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link Famille}
 */
@Named
public class FamilleDto implements Serializable {
    private  int id;
    private  CatalogueDto idcatalogue;
    @Size(max = 254)
    private  String reference;
    @Size(max = 254)
    private  String label;
    @Size(max = 254)
    private  String description;
    private  Boolean statut =true;
    private  LocalDate datecreation;



    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public CatalogueDto getIdcatalogue() {
        return idcatalogue;
    }
    public void setIdcatalogue(CatalogueDto idcatalogue) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FamilleDto entity = (FamilleDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.idcatalogue, entity.idcatalogue) &&
                Objects.equals(this.reference, entity.reference) &&
                Objects.equals(this.label, entity.label) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.statut, entity.statut) &&
                Objects.equals(this.datecreation, entity.datecreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, idcatalogue, reference, label, description, statut, datecreation);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "idcatalogue = " + idcatalogue + ", " +
                "reference = " + reference + ", " +
                "label = " + label + ", " +
                "description = " + description + ", " +
                "statut = " + statut + ", " +
                "datecreation = " + datecreation + ")";
    }

    public void clear(){
        this.id = 0;
        this.idcatalogue = null;
        this.reference = null;
        this.label = null;
        this.description = null;
        this.statut = true;
        this.datecreation = null;
    }
}