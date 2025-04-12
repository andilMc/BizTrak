package beans;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Named;
import org.ocpsoft.rewrite.annotation.Join;

import java.io.Serializable;

@Named
@SessionScoped
@Join(path = "/", to = "views/login.xhtml")
public class LoginBean implements Serializable {

    private String identifiant ;
    public void lgoin() {
        // Implement login logic here
        System.out.println("Login method called with identifiant: " + identifiant);
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }
}
