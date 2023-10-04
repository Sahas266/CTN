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
import org.ccode.asset.ctn.image.rest.services.AlertService;
import org.ccode.asset.ctn.image.rest.services.LocationService;

/**
 * Root resource (exposed at "telescopes" path)
 */
@Path("alerts")
public class AlertResource {

	public AlertService alertService = new AlertService();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	@GET
	@Path("/celestial-events/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCelestialEvents() {
		return alertService.getCelestialEventsAsJsonString();
	}

	@GET
	@Path("/celestial-bodies/all")
	@Produces(MediaType.APPLICATION_JSON)
	public String getCelestialBodys() {
		return alertService.getCelestialBodysAsJsonString();
	}
  
}
