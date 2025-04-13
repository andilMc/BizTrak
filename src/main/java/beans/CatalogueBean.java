package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import models.Catalogue;
import models.DAO.GenericDAO;
import models.DTO.CatalogueDto;

import java.util.List;
import java.time.LocalDate;
import java.util.Date;

import org.ocpsoft.rewrite.annotation.Join;

@Named
@RequestScoped
@Join(path = "/cat",to = "views/catalogue.xhtml")
public class CatalogueBean {

	private final GenericDAO<Catalogue> dao = new GenericDAO<>(Catalogue.class);

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
	    
	    public void delete(Catalogue cat) {
	        if (cat != null && cat.getId() != 0) {
	            dao.delete(cat);
	        }
	    }
	    
	    

}
