package beans;

import enums.Type;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import models.DAO.GenericDAO;
import models.DTO.TypevarieteDto;
import models.Typevariete;
import models.Unitemesure;
import org.ocpsoft.rewrite.annotation.Join;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Named
@RequestScoped
@Join(path = "/type", to = "views/variation.xhtml")
public class TypeVariationBean {

    @Inject
    private TypevarieteDto typeVariation;

    public List<Typevariete> getTypeVariations() {
        GenericDAO<Typevariete> typevarieteGenericDAO = new GenericDAO<>(Typevariete.class);
        return typevarieteGenericDAO.findAll();
    }

    public List<String> getTypes(){
        return  Arrays.stream(Type.values())
                .map(Type::getTypeName)
                .collect(Collectors.toList());
    }
    public TypevarieteDto getTypeVariation() {
        return typeVariation;
    }

    public void setTypeVariation(TypevarieteDto typeVariation) {
        this.typeVariation = typeVariation;
    }

    public void addTypeVariation() {
        try {
            GenericDAO<Typevariete>  typevarieteDAO= new GenericDAO<>(Typevariete.class);
            Typevariete type = new Typevariete();
            type.setId(typeVariation.getId());
            type.setLabel(typeVariation.getLabel());
            type.setStatut(typeVariation.getStatut());
            type.setTypevaleur(typeVariation.getTypevaleur());
            type.setDatecreation(LocalDate.now());

            if (typeVariation.getId() != 0) {
                typevarieteDAO.update(type);
            } else {
                typevarieteDAO.save(type);
            }

            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Success", "Unit of measure added successfully."));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Failed to add unit of measure: " + e.getMessage()));
        }finally {
            typeVariation.clear();
        }
    }


    public void deleteTypevariete(int id) {
        try {
            GenericDAO<Typevariete> TypevarieteDAO = new GenericDAO<>(Typevariete.class);
            Typevariete uniteMesure = TypevarieteDAO.findById(id);
            if (uniteMesure != null) {
                TypevarieteDAO.delete(uniteMesure);
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

    public void initTvVal(int id) {
        GenericDAO<Typevariete> TypevarieteDAO = new GenericDAO<>(Typevariete.class);
        Typevariete Typevariete = TypevarieteDAO.findById(id);
        if (Typevariete != null) {
            typeVariation.setId(Typevariete.getId());
            typeVariation.setLabel(Typevariete.getLabel());
            typeVariation.setStatut(Typevariete.getStatut());
            typeVariation.setTypevaleur(Typevariete.getTypevaleur());
        } else {
            FacesContext.getCurrentInstance().addMessage(null,
                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Error", "Unit of measure not found."));
        }
    }



}
