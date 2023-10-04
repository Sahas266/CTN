package org.ccode.asset.ctn.image.rest.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.ccode.asset.ctn.image.rest.models.Location;

public class LocationDAO {
	public List<Location> locationList = new ArrayList<Location>();
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

	public List<Location> readlocationList() {
		// Retrieve data from the database.
		connect();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM CelestialLocation");
			// Iterate over the ResultSet and print the results.
			while (resultSet.next()) {
				Location location = new Location();
				location.setId(resultSet.getInt("ID"));
				location.setCelestialLongitude(resultSet.getDouble("CELESTIALLONGITUDE"));
				location.setCelestialLatitude(resultSet.getDouble("CELESTIALLATITUDE"));
				locationList.add(location);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printLocations(locationList);
		return locationList;
	}

	public void addLocation(double celestialLongitude, double celestialLatitude) {
		connect();
		Statement statement;
		String query = "INSERT INTO CelestialLocation (celestialLongitude, celestialLatitude) values (" + celestialLongitude + ", " + celestialLatitude + ")";
		System.out.println(query);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateLocation(int id, double celestialLongitude, double celestialLatitude) {
		connect();
		Statement statement;
		String query = "Update CelestialLocation SET celestialLongitude = " + celestialLongitude + ", celestialLatitude = " + celestialLatitude + " where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteLocation(int id) {
		connect();
		Statement statement;
		String query = "Delete from CelestialLocation where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printLocations(List<Location> LocationsList) {
		for (Location t : LocationsList) {
			System.out.println(" ID:" + t.getId() + "; CelestialLongitude:"	+ t.getCelestialLongitude() + ";  CelestialLatitude:" + t.getCelestialLatitude());
		}
	}

	public static void main(String[] args) {
		LocationDAO dao = new LocationDAO();
//		dao.updateLocation(4,5);
//		dao.addLocation("test",2,3,6.5,5.0);
//		dao.displayClassPath();
//		dao.connect();
//		dao.createlocationList();
//		List<Location> Locations = dao.readlocationList();
//		dao.printLocations(Locations);
	}

}
