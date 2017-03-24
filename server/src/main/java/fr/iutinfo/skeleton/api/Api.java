package fr.iutinfo.skeleton.api;
/**
 * @author team9
 * CONFIGURATION DE L API
 */
import fr.iutinfo.skeleton.auth.AuthFilter;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.filter.RolesAllowedDynamicFeature;

import javax.ws.rs.ApplicationPath;

@ApplicationPath("/CycleMate/")
public class Api extends ResourceConfig {

    public Api() {
        packages("fr.iutinfo.skeleton.api");
        //register(LoggingFilter.class);
        register(AuthFilter.class);
        register(RolesAllowedDynamicFeature.class);
    }

}
