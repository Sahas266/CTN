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
import org.ccode.asset.ctn.image.rest.services.LocationService;

/**
 * Root resource (exposed at "telescopes" path)
 */
@Path("locations")
public class LocationResource {

	public LocationService locationService = new LocationService();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	@GET
	@Path("/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getLocations() {
		return locationService.getLocationsAsJsonString();
	}

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public String getLocation(@PathParam("id") int locationID) {
    	return locationService.getLocationAsJsonString(locationID);
    }

    @DELETE 
    @Path("/{id}") 
    @Produces(MediaType.APPLICATION_JSON) 
    public String deleteLocation(@PathParam("id") int id){ 
    	return locationService.deleteLocation(id);
    }  
    
    @POST 
    @Path("/{id}")  
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public String uplodateLocation(@FormParam("id") int id, @FormParam("celestialLongitude") double celestialLongitude, @FormParam("celestialLatitude") double celestialLatitude) { 
    	return locationService.updateLocation(id, celestialLongitude, celestialLatitude);
    }
    
    @PUT 
    @Path("/add") 
    @Produces(MediaType.APPLICATION_JSON) 
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED) 
    public String createStudent(@FormParam("celestialLongitude") double celestialLongitude, @FormParam("celestialLatitude") double celestialLatitude) { 
    	return locationService.addLocation(celestialLongitude, celestialLatitude);
    }
}
