package models.DTO;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;

import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Objects;

/**
 * DTO for {@link models.Unitemesure}
 */
@Named
public class UnitemesureDto implements Serializable {
	
  private int id;
  @Size(max = 254)
  private String label;

  @Size(max = 254)
  private String symbole;
  private Boolean statut = true;


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

  public Boolean getStatut() {
      return statut;
  }

  public void setStatut(Boolean statut) {
      this.statut = statut;
  }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UnitemesureDto entity = (UnitemesureDto) o;
        return Objects.equals(this.id, entity.id) &&
                Objects.equals(this.label, entity.label) &&
                Objects.equals(this.statut, entity.statut);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, label, statut);
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" +
                "id = " + id + ", " +
                "label = " + label + ", " +
                "statut = " + statut + ")";
    }

    public String getSymbole() {
        return symbole;
    }

    public void setSymbole(String symbole) {
        this.symbole = symbole;
    }

    public void clear() {
        this.id = 0;
        this.label = null;
        this.statut = true;
        this.symbole = null;
    }
}