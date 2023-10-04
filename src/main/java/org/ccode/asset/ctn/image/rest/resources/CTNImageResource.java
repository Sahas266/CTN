package org.ccode.asset.ctn.image.rest.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.ccode.asset.ctn.image.rest.models.Telescope;
import org.ccode.asset.ctn.image.rest.services.TelescopeService;

/**
 * Root resource (exposed at "students" path)
 */
@Path("ctn")
public class CTNImageResource {

	public TelescopeService telescopeService = new TelescopeService();

	/**
	 * Method handling HTTP GET requests. The returned object will be sent to the
	 * client as "text/plain" media type.
	 *
	 * @return String that will be returned as a text/plain response.
	 */

	@GET
	@Path("/telescopes")
	@Produces(MediaType.APPLICATION_JSON)
	public String getTelescopes() {
		return telescopeService.getTelescopesAsJsonString();
	}

//	@GET
//	@Path("/observations")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Observation> getObservations() {
//		// Get the list of observations in the CTN.
//		List<Observation> observations = observationService.getObservations();
//
//		// Return the list of observations.
//		return observations;
//	}
//
//	@GET
//	@Path("/events")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Event> getEvents() {
//		// Get the list of events in the CTN.
//		List<Event> events = eventService.getEvents();
//
//		// Return the list of events.
//		return events;
//	}
//
//	@GET
//	@Path("/alerts")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Alert> getAlerts() {
//		// Get the list of alerts in the CTN.
//		List<Alert> alerts = alertService.getAlerts();
//
//		// Return the list of alerts.
//		return alerts;
//	}
//
//	@POST
//	@Path("/commands")
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Produces(MediaType.APPLICATION_JSON)
//	public Command sendCommand(Command command) {
//		// Send the command to the CTN.
//		commandService.sendCommand(command);
//
//		// Return the command.
//		return command;
//	}
//
//	// Specific endpoints for different types of transient astronomical events, such
//	// as gamma-ray bursts, gravitational waves, and supernovae.
//
//	@GET
//	@Path("/gamma-ray-bursts")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<GammaRayBurst> getGammaRayBursts() {
//		// Get the list of gamma-ray bursts in the CTN.
//		List<GammaRayBurst> gammaRayBursts = gammaRayBurstService.getGammaRayBursts();
//
//		// Return the list of gamma-ray bursts.
//		return gammaRayBursts;
//	}
//
//	@GET
//	@Path("/gravitational-waves")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<GravitationalWave> getGravitationalWaves() {
//		// Get the list of gravitational waves in the CTN.
//		List<GravitationalWave> gravitationalWaves = gravitationalWaveService.getGravitationalWaves();
//
//		// Return the list of gravitational waves.
//		return gravitationalWaves;
//	}
//
//	@GET
//	@Path("/supernovae")
//	@Produces(MediaType.APPLICATION_JSON)
//	public List<Supernova> getSupernovae() {
//		// Get the list of supernovae in the CTN.
//		List<Supernova> supernovae = supernovaService.getSupernovae();
//
//		// Return the list of supernovae.
//		return supernovae;
//	}
//
//	// Specific endpoints for specific tasks, such as calibration, data reduction,
//	// and data analysis.
//
//	@POST
//	@Path("/calibrate")
//	public void calibrate() {
//		// Calibrate the telescopes in the CTN.
//		telescopeService.calibrate();
//	}
//
//	@POST
//	@Path("/reduce")
//	public void reduce() {
//		// Reduce the data collected by the CTN.
//		observationService.reduce();
//	}
//
//	@POST
//	@Path("/analyze")
//	public void analyze() {
//		// Analyze the data collected by the CTN.
//		analysisService.analyze();
//	}

}
