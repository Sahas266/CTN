package org.ccode.asset.ctn.image.rest.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.ccode.asset.ctn.image.rest.models.CelestialEvent;

import org.ccode.asset.ctn.image.rest.models.Location;

public class CelestialEventDAO {
	public List<CelestialEvent> celestialEventList = new ArrayList<CelestialEvent>();
	public static Connection connection;

	public void connect() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			connection = DriverManager.getConnection("jdbc:derby:c:\\temp\\myDB;create=true");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void displayClassPath() {
		String classpath = System.getProperty("java.class.path");
		String[] classpathEntries = classpath.split(File.pathSeparator);
		for (String path : classpathEntries) {
			System.out.println(path);
		}
	}

	public List<CelestialEvent> readCelestialEventList() {
		// Retrieve data from the database.
		connect();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM CelestialEvent");
			// Iterate over the ResultSet and print the results.
			while (resultSet.next()) {
				CelestialEvent event = new CelestialEvent();
				event.setId(resultSet.getInt("ID"));
				event.setEvent(resultSet.getString("EVENT"));
				event.setLocation(resultSet.getInt("LOCATION"));
				celestialEventList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printCelestialEvents(celestialEventList);
		return celestialEventList;
	}

	public void addEvent(String event, int location) {
		connect();
		Statement statement;
		String query = "INSERT INTO CelestialEvent (event, location) values ('" + event + "', " + location + ")";
		System.out.println(query);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateEvent(int id, int location) {
		connect();
		Statement statement;
		String query = "Update CelestialEvent SET location = " + location + " where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteEvent(int id) {
		connect();
		Statement statement;
		String query = "Delete from CelestialEvent where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printCelestialEvents(List<CelestialEvent> celestialEventList) {
		for (CelestialEvent t : celestialEventList) {
			System.out.println(" ID:" + t.getId() + "; Event:"	+ t.getEvent() + ";  Location:" + t.getLocation());
		}
	}

	public static void main(String[] args) {
		CelestialEventDAO dao = new CelestialEventDAO();
		dao.printCelestialEvents(dao.readCelestialEventList());

//		dao.updateLocation(4,5);
//		dao.addLocation("test",2,3,6.5,5.0);
//		dao.displayClassPath();
//		dao.connect();
//		dao.createlocationList();
//		List<Location> Locations = dao.readlocationList();
//		dao.printLocations(Locations);
	}

}
