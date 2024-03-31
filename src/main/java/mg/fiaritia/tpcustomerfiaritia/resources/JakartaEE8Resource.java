package mg.fiaritia.tpcustomerfiaritia.resources;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 *
 * @author 
 */
@Path("rest")
public class JakartaEE8Resource {
    
    @GET
    public Response ping(){
        System.out.println("tonga ato");
        return Response
                .ok("ping")
                .build();
    }
}
