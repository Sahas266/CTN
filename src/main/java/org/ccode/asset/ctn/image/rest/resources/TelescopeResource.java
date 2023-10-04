package org.ccode.asset.ctn.image.rest.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ccode.asset.ctn.image.rest.models.Telescope;
import org.ccode.asset.ctn.image.rest.services.TelescopeService;

/**
 * Root resource (exposed at "telescopes" path)
 */
@Path("telescopes")
public class TelescopeResource {

	public TelescopeService telescopeService = new TelescopeService();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTelescopes() {
		return telescopeService.getTelescopesAsJsonString();
	}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getStudent(@PathParam("id") int telescopeID) {
    	return telescopeService.getTelescopeAsJsonString(telescopeID);
    }

    @DELETE 
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public String deleteStudent(@PathParam("id") int id){ 
    	return telescopeService.deleteTelescope(id);
    }  
    
    @POST 
    @Path("/{id}")  
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public String updateStudent(@FormParam("id") int id, @FormParam("location") int location) { 
    	return telescopeService.updateTelescope(id, location);
    }
    
    @PUT 
    @Path("/add") 
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public String createStudent(@FormParam("name") String name, @FormParam("location") int location, @FormParam("type") int telescopeType, @FormParam("aperture") double aperture, @FormParam("fieldOfView") double fieldOfView) { 
    	return telescopeService.addTelescope(name, location, telescopeType, aperture, fieldOfView);
    }
    
//	@GET
//	@Path("/types")
//	@Produces(MediaType.APPLICATION_JSON)
//	public String getTelescopeTypes() {
//		return telescopeService.getTelescopeTypeAsJsonString();
//	}
}
