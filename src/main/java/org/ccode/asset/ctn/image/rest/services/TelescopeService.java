package org.ccode.asset.ctn.image.rest.services;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.ccode.asset.ctn.image.rest.dao.TelescopeDAO;
import org.ccode.asset.ctn.image.rest.models.Location;
import org.ccode.asset.ctn.image.rest.models.Telescope;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class TelescopeService {
	public List<Telescope> telescopes;
	TelescopeDAO telescopeDAO = new TelescopeDAO();

	public TelescopeService() {
		System.out.println("callilng TelescopeService constructor");
		telescopeDAO.displayClassPath();
		telescopes = telescopeDAO.readTelescopeList();
	}

	public List<Telescope> getTelescopes() {
		return telescopes;
	}

	public String getTelescopesAsJsonString() {
		System.out.println("calling getTelescopesAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {
			json = mapper.writeValueAsString(telescopes);
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

	public String getTelescopeAsJsonString(int id) {
		System.out.println("calling getTelescopeAsJsonString");
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {

			for (Telescope telescope : telescopes) {
				if (telescope.getId() == id) {
					json = mapper.writeValueAsString(telescope);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}

//	public String getTelescopeTypeAsJsonString() {
//		System.out.println("calling getTelescopeTypeAsJsonString");
//		List<String> telescopeTypes = new ArrayList<String>();
//		int i=0;
//		for (TelescopeType type : TelescopeType.values()) {
//			telescopeTypes.add(i + " : " + type.toString());
//			i++;
//		}
//		
//		ObjectMapper mapper = new ObjectMapper();
//		String json = new String();
//		try {
//			json = mapper.writeValueAsString(telescopeTypes);
//		} catch (JsonProcessingException e) {
//			e.printStackTrace();
//		}
//		return json;
//	}
	
	public String deleteTelescope(int id) {
		System.out.println("calling deleteStudent");
		telescopeDAO.deleteTelescope(id);
		return "Successful";

	}	
	
	public String updateTelescope(int id, int location) {
		System.out.println("calling updateTelescope");
		telescopeDAO.updateTelescope(id, location);
		telescopes = telescopeDAO.readTelescopeList();
		ObjectMapper mapper = new ObjectMapper();
		String json = new String();
		try {

			for (Telescope telescope : telescopes) {
				if (telescope.getId() == id) {
					json = mapper.writeValueAsString(telescope);
				}
			}
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return json;
	}	
	
	public String addTelescope(String name, int location, int type, double aperture, double fieldOfView) {
		System.out.println("addTelescope");
		telescopeDAO.addTelescope(name, location, type, aperture, fieldOfView);
		telescopes = telescopeDAO.readTelescopeList();
		return "Successful";
	}	
	

	// return studentService.getStudentAsJsonString(studentID);

	public static void main(String[] args) throws JsonProcessingException {
		TelescopeService service = new TelescopeService();
		//System.out.println(service.getTelescopesAsJsonString());
//		System.out.println(service.getTelescopeTypeAsJsonString());
		System.out.println(service.updateTelescope(4, 2));
		System.out.println(service.deleteTelescope(3));
		System.out.println(service.addTelescope("new", 5, 5, 5.5, 6.5));
		
//		service.addTelescope(6, "telescope-1",  1, 0.2, 0.3);
//		System.out.println(service.getStudentsAsJsonString());
	}
}
