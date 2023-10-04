package org.ccode.asset.ctn.image.rest.services;

import java.util.ArrayList;
import java.util.List;

import org.ccode.asset.ctn.image.rest.dao.CelestialBodyDAO;
import org.ccode.asset.ctn.image.rest.dao.CelestialEventDAO;
import org.ccode.asset.ctn.image.rest.dao.LocationDAO;
import org.ccode.asset.ctn.image.rest.dao.TelescopeDAO;
import org.ccode.asset.ctn.image.rest.models.CelestialBody;
import org.ccode.asset.ctn.image.rest.models.CelestialEvent;
import org.ccode.asset.ctn.image.rest.models.Location;
import org.ccode.asset.ctn.image.rest.models.Telescope;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class AlertService {
	public List<Location> locations;
	public List<Telescope> telescopes;
	public List<CelestialBody> celestialBodys;
	public List<CelestialEvent> celestialEvents;
	
	
	LocationDAO locationDAO = new LocationDAO();
	TelescopeDAO telescopeDAO = new TelescopeDAO();
	CelestialBodyDAO celestialBodyDAO = new CelestialBodyDAO();
	CelestialEventDAO celestialEventDAO = new CelestialEventDAO();


	public AlertService() {
		System.out.println("calling AlertService constructor");
		locationDAO.displayClassPath();
		locations = locationDAO.readlocationList();
		telescopes = telescopeDAO.readTelescopeList();
		celestialBodys = celestialBodyDAO.readcelestialBodyList();
		celestialEvents = celestialEventDAO.readCelestialEventList();
	}

	public String getCelestialEventsAsJsonString() {
		System.out.println("calling getCelestialEventsAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {
			json = mapper.writeValueAsString(celestialEvents);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String getCelestialEventAsJsonString(int id) {
		System.out.println("calling getLocationAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {

			for (CelestialEvent event : celestialEvents) {
				if (event.getId() == id) {
					json = mapper.writeValueAsString(event);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String getCelestialBodysAsJsonString() {
		System.out.println("calling getCelestialBodysAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {
			json = mapper.writeValueAsString(celestialBodys);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String getCelestialBodyAsJsonString(int id) {
		System.out.println("calling getCelestialBodyAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {

			for (CelestialBody body  : celestialBodys) {
				if (body.getId() == id) {
					json = mapper.writeValueAsString(body);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}
	

	public static void main(String[] args) throws JsonProcessingException {
		AlertService service = new AlertService();
	}
}
