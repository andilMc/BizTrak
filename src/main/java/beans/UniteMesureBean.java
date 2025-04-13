package beans;

import jakarta.el.MethodExpression;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import models.DAO.GenericDAO;
import models.DTO.UnitemesureDto;
import models.Unitemesure;
import org.ocpsoft.rewrite.annotation.Join;

import java.time.LocalDate;
import java.util.Date;
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


    public void addUnite() {
        try {
            GenericDAO<Unitemesure> uniteDAO = new GenericDAO<>(Unitemesure.class);
            Unitemesure uniteMesure = new Unitemesure();
            uniteMesure.setId(unite.getId());
            uniteMesure.setLabel(unite.getLabel());
            uniteMesure.setStatut(unite.getStatut());
            uniteMesure.setSymbole(unite.getSymbole());
            uniteMesure.setDatecreation(LocalDate.now());

            if (unite.getId() != 0) {
                System.out.println("update");
                uniteDAO.update(uniteMesure);
            } else {
                System.out.println("save");
                uniteDAO.save(uniteMesure);
            }

            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Unit of measure added successfully."));
            unite.clear();
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add unit of measure: " + e.getMessage()));
            unite.clear();
        }finally {
//            unite.clear();
        }
    }

    public void deleteUnite(int id) {
        try {
            GenericDAO<Unitemesure> uniteDAO = new GenericDAO<>(Unitemesure.class);
            Unitemesure uniteMesure = uniteDAO.findById(id);
            if (uniteMesure != null) {
                uniteDAO.delete(uniteMesure);
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Unit of measure deleted successfully."));
            } else {
                FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Unit of measure not found."));
            }
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to delete unit of measure: " + e.getMessage()));
        }

    }

    public void initUniteVal(int id) {
        GenericDAO<Unitemesure> uniteDAO = new GenericDAO<>(Unitemesure.class);
        Unitemesure uniteMesure = uniteDAO.findById(id);
        if (uniteMesure != null) {
            unite.setId(uniteMesure.getId());
            unite.setLabel(uniteMesure.getLabel());
            unite.setStatut(uniteMesure.getStatut());
            unite.setSymbole(uniteMesure.getSymbole());
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Unit of measure not found."));
        }
    }
}
