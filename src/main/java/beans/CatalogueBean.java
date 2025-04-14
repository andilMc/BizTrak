package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.context.SessionScoped;
import jakarta.faces.application.FacesMessage;
import jakarta.faces.context.FacesContext;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import models.Catalogue;
import models.DAO.GenericDAO;

import java.util.ArrayList;
import java.util.List;
import java.io.Serializable;
import java.time.LocalDate;

import models.DTO.CatalogueDto;
import models.Famille;
import models.FamilleDto;
import org.ocpsoft.rewrite.annotation.Join;

@Named
@SessionScoped
@Join(path = "/cat",to = "views/catalogue.xhtml")
public class CatalogueBean implements Serializable  {
 
	private final GenericDAO<Catalogue> dao = new GenericDAO<>(Catalogue.class);

	@Inject
	private CatalogueDto catalogueDto ;
	@Inject
	private FamilleDto familleDto;
    private Catalogue newCatalogue = new Catalogue(); // 👈 Ajout pour insertion

    // Pour afficher les catalogues
    public List<Catalogue> getCatalogueList() {
        return dao.findAll();
    }

    // Getter & Setter pour le formulaire
    public Catalogue getNewCatalogue() {
        return newCatalogue;
    }

    public void setNewCatalogue(Catalogue newCatalogue) {
        this.newCatalogue = newCatalogue;
    }


	    private String generateReference() {
	        // Récupérer le nombre total de catalogues (ou le dernier ID)
	        long count = dao.count(); // Crée cette méthode dans le DAO si elle n'existe pas
	
	        int nextNumber = (int) (count + 1); // ou base-toi sur le max ID
	        return String.format("CAT-%03d", nextNumber); // CAT-001, CAT-002, etc.
	    }
	    
	    public void addCatalogue() {
	        newCatalogue.setDatecreation(LocalDate.now());
	        newCatalogue.setStatut(true);
	
	        // Générer la référence automatiquement
	        String ref = generateReference();
	        newCatalogue.setReference(ref);
	
	        dao.save(newCatalogue);
	        newCatalogue = new Catalogue();
	    } 
	    
	    public void deleteCatalogue(int id) {
	        try {
	            GenericDAO<Catalogue> catDAO = new GenericDAO<>(Catalogue.class);
	            Catalogue cat = catDAO.findById(id);
	            if (cat != null) {
	                catDAO.delete(cat);
	                FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage(FacesMessage.SEVERITY_INFO, "Succès", "Catalogue supprimé avec succès."));
	            } else {
	                FacesContext.getCurrentInstance().addMessage(null,
	                    new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Catalogue introuvable."));
	            }
	        } catch (Exception e) {
	            FacesContext.getCurrentInstance().addMessage(null,
	                new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erreur", "Échec de suppression du catalogue : " + e.getMessage()));
	        }
	    }

    public CatalogueDto getCatalogueDto() {
        return catalogueDto;
    }

    public void setCatalogueDto(CatalogueDto catalogueDto) {
        this.catalogueDto = catalogueDto;
    }

	public void selectCat(int id) {
		Catalogue cat = dao.findById(id);
		System.out.println(cat);
		if (cat != null) {
			catalogueDto.setId(cat.getId());
			catalogueDto.setReference(cat.getReference());
			catalogueDto.setLabel(cat.getLabel());
			catalogueDto.setDescription(cat.getDescription());
			catalogueDto.setStatut(cat.getStatut());
			catalogueDto.setDatecreation(cat.getDatecreation());
		}
	}

	public List<Famille> getFamilles(int idCat){
		Catalogue cat = dao.findById(idCat);
		if (cat != null) {
			GenericDAO<Famille> familleDAO = new GenericDAO<>(Famille.class);
			 return familleDAO.findByCriteria("idcatalogue", cat);
		}
		return null;
	}

    public FamilleDto getFamilleDto() {
        return familleDto;
    }

    public void setFamilleDto(FamilleDto familleDto) {
        this.familleDto = familleDto;
    }

	public void addFamille() {
		GenericDAO<Catalogue> catalogueGenericDAO = new GenericDAO<>(Catalogue.class);
		Catalogue cat = catalogueGenericDAO.findById(catalogueDto.getId());
		
        GenericDAO<Famille> familleDAO = new GenericDAO<>(Famille.class);
        Famille famille = new Famille();
        famille.setLabel(familleDto.getLabel());
        famille.setDescription(familleDto.getDescription());
        famille.setStatut(familleDto.getStatut());
        famille.setIdcatalogue(cat);
        famille.setDatecreation(LocalDate.now());
        famille.setReference(generateFReference());
        familleDAO.save(famille);
    }

	private String generateFReference() {
		GenericDAO<Famille> familleDAO = new GenericDAO<>(Famille.class);
		long count = familleDAO.count();
		int nextNumber = (int) (count + 1);
		return String.format("FAM-%03d", nextNumber);
	}
}
