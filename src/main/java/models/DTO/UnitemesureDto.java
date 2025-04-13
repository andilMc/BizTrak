package models.DTO;

import jakarta.inject.Named;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link models.Unitemesure}
 */
@Named
public class UnitemesureDto implements Serializable {
    private Integer id;
    @Size(max = 254)
    private  String label;
    @Size(max = 254)
    private  String typevaleur;
    private  Boolean statut;
    public UnitemesureDto() {}
    public UnitemesureDto(Integer id, String label, String typevaleur, Boolean statut) {
        this.id = id;
        this.label = label;
        this.typevaleur = typevaleur;
        this.statut = statut;
    }

    public Integer getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

    public String getTypevaleur() {
        return typevaleur;
    }

    public Boolean getStatut() {
        return statut;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitemesureDto entity = (UnitemesureDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.label, entity.label) &&
                Objects.equals(this.typevaleur, entity.typevaleur) &&
                Objects.equals(this.statut, entity.statut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, typevaleur, statut);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "label = " + label + ", " +
                "typevaleur = " + typevaleur + ", " +
                "statut = " + statut + ")";
    }
}