package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.ocpsoft.rewrite.annotation.Join;

@Named
@RequestScoped
@Join(path = "/init",to = "views/init.xhtml")
public class InitilizerBean {

}
