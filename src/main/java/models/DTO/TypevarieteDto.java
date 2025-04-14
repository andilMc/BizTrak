package models.DTO;

import jakarta.inject.Inject;
import jakarta.inject.Named;
import models.Typevariete;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

/**
 * DTO for {@link Typevariete}
 */
@Named
public class TypevarieteDto implements Serializable {

    private static final long serialVersionUID = 1L;

    private int id;

    @Size(max = 254)
    private String label;

    @Size(max = 254)
    private String typevaleur;

    private Boolean statut = true;

    private LocalDate datecreation;


    public int getId() {
        return id;
    }
    public void setId(int id) {
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



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TypevarieteDto entity = (TypevarieteDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.label, entity.label) &&
                Objects.equals(this.typevaleur, entity.typevaleur) &&
                Objects.equals(this.statut, entity.statut) &&
                Objects.equals(this.datecreation, entity.datecreation);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, typevaleur, statut, datecreation);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "label = " + label + ", " +
                "typevaleur = " + typevaleur + ", " +
                "statut = " + statut + ", " +
                "datecreation = " + datecreation + ")";
    }

    public void clear() {
        this.id = 0;
        this.label = null;
        this.typevaleur = null;
        this.statut = null;
        this.datecreation = null;
    }
}