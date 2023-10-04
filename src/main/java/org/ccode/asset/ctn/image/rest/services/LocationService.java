package org.ccode.asset.ctn.image.rest.services;

import java.util.ArrayList;
import java.util.List;
import org.ccode.asset.ctn.image.rest.dao.LocationDAO;
import org.ccode.asset.ctn.image.rest.models.Location;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class LocationService {
	public List<Location> locations;
	LocationDAO LocationDAO = new LocationDAO();

	public LocationService() {
		System.out.println("callilng locationservice constructor");
		LocationDAO.displayClassPath();
		locations = LocationDAO.readlocationList();
	}

	public List<Location> getlocations() {
		return locations;
	}

	public String getLocationsAsJsonString() {
		System.out.println("calling getlocationsAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {
			json = mapper.writeValueAsString(locations);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String getLocationAsJsonString(int id) {
		System.out.println("calling getLocationAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {

			for (Location Location : locations) {
				if (Location.getId() == id) {
					json = mapper.writeValueAsString(Location);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String deleteLocation(int id) {
		System.out.println("calling deleteStudent");
		LocationDAO.deleteLocation(id);
		return "Successful";
	}

	public String updateLocation(int id, double celestialLongitude, double celestialLatitude) {
		System.out.println("calling updateLocation");
		LocationDAO.updateLocation(id, celestialLongitude, celestialLatitude);
		locations = LocationDAO.readlocationList();
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {

			for (Location Location : locations) {
				if (Location.getId() == id) {
					json = mapper.writeValueAsString(Location);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String addLocation(double celestialLongitude, double celestialLatitude) {
		System.out.println("addLocation");
		LocationDAO.addLocation(celestialLongitude, celestialLatitude);
		locations = LocationDAO.readlocationList();
		return "Successful";
	}

	public static void main(String[] args) throws JsonProcessingException {
		LocationService service = new LocationService();
		System.out.println(service.getLocationsAsJsonString());
		System.out.println(service.getLocationAsJsonString(2));
		System.out.println(service.updateLocation(4, 2.425, 2.425));
		System.out.println(service.deleteLocation(3));
		System.out.println(service.addLocation(129.423654501, 14.615972976));
	}
}
