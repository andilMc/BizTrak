package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.ocpsoft.rewrite.annotation.Join;

@Named
@RequestScoped
@Join(path = "/cat",to = "views/catalogue.xhtml")
public class InitilizerBean {

}
