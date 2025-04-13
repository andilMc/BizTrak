package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import models.DAO.GenericDAO;
import models.DTO.UnitemesureDto;
import models.Unitemesure;
import org.ocpsoft.rewrite.annotation.Join;

import java.util.List;

@Named
@RequestScoped
@Join(path = "/mesure", to = "views/uniteMesure.xhtml")
public class UniteMesureBean {
    @Inject
    private UnitemesureDto unite;
    public List<Unitemesure> getUnites() {
        GenericDAO<Unitemesure> unitemesureDAO = new GenericDAO<>(Unitemesure.class);
        return unitemesureDAO.findAll();
    }


    public UnitemesureDto getUnite() {
        return unite;
    }

    public void setUnite(UnitemesureDto unite) {
        this.unite = unite;
    }
}
