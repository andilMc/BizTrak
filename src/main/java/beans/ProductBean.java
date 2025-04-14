package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;
import models.Article;
import models.DAO.GenericDAO;
import models.DTO.ProduitDto;
import models.Produit;
import org.ocpsoft.rewrite.annotation.Join;

import java.util.List;
import java.util.Set;

@Named
@RequestScoped
@Join(path = "/products", to = "views/product.xhtml")
public class ProductBean {

    @Inject
    private ProduitDto produitDto;
    public List<Produit> getProducts() {
        GenericDAO<Produit> produitDAO = new GenericDAO<>(Produit.class);
        return produitDAO.findAll();
    }

    public double getQuantite(int id) {
        double quantite = 0;
        GenericDAO<Produit> produitDAO = new GenericDAO<>(Produit.class);
        GenericDAO<Article> articleDAO = new GenericDAO<>(Article.class);
        Produit produit = produitDAO.findById(id);
        Set<Article> articles = produit.getArticles();
        for (Article article : articles) {
            if (article.getIdproduit().getId() == id) {
                quantite += article.getQuantite().doubleValue();
            }
        }
        return quantite;
    }
}
