package beans;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Named;
import org.ocpsoft.rewrite.annotation.Join;

@Named
@RequestScoped
@Join(path = "/dash", to = "views/dash.xhtml")
public class DashBean {
}
