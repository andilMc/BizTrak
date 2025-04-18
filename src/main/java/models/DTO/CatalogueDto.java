package models.DTO;

import jakarta.inject.Named;
import models.Catalogue;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link Catalogue}
 */
@Named
public class CatalogueDto implements Serializable {
    private  int id;
    @Size(max = 254)
    private  String reference;
    @Size(max = 254)
    private  String label;
    @Size(max = 254)
    private  String description;
    private  Boolean statut;
    private  LocalDate datecreation;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public void setLabel(String label) {
        this.label = label;
    }
    public String getLabel() {
        return label;
    }


    public void setDescription(String description) {
        this.description = description;
    }
    public String getDescription() {
        return description;
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
        CatalogueDto entity = (CatalogueDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.reference, entity.reference) &&
                Objects.equals(this.label, entity.label) &&
                Objects.equals(this.description, entity.description) &&
                Objects.equals(this.statut, entity.statut) &&
                Objects.equals(this.datecreation, entity.datecreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, reference, label, description, statut, datecreation);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "reference = " + reference + ", " +
                "label = " + label + ", " +
                "description = " + description + ", " +
                "statut = " + statut + ", " +
                "datecreation = " + datecreation + ")";
    }
}