package org.ccode.asset.ctn.image.rest.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import org.ccode.asset.ctn.image.rest.models.CelestialBody;

public class CelestialBodyDAO {
	public List<CelestialBody> celestialBodyList = new ArrayList<CelestialBody>();
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

	public List<CelestialBody> readcelestialBodyList() {
		// Retrieve data from the database.
		connect();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM CelestialBody");
			// Iterate over the ResultSet and print the results.
			while (resultSet.next()) {
				CelestialBody event = new CelestialBody();
				event.setId(resultSet.getInt("ID"));
				event.setName(resultSet.getString("NAME"));
				event.setLocation(resultSet.getInt("LOCATION"));
				celestialBodyList.add(event);
			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printCelestialBodys(celestialBodyList);
		return celestialBodyList;
	}

	public void addCelestialBody(String name, int location) {
		connect();
		Statement statement;
		String query = "INSERT INTO CelestialBody (event, location) values ('" + name + "', " + location + ")";
		System.out.println(query);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void updateCelestialBody(int id, int location) {
		connect();
		Statement statement;
		String query = "Update CelestialBody SET location = " + location + " where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void deleteCelestialBody(int id) {
		connect();
		Statement statement;
		String query = "Delete from CelestialBody where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printCelestialBodys(List<CelestialBody> celestialBodyList) {
		for (CelestialBody t : celestialBodyList) {
			System.out.println(" ID:" + t.getId() + "; Event:"	+ t.getName() + ";  Location:" + t.getLocation());
		}
	}

	public static void main(String[] args) {
		CelestialBodyDAO dao = new CelestialBodyDAO();
		dao.printCelestialBodys(dao.readcelestialBodyList());
//		dao.updateLocation(4,5);
//		dao.addLocation("test",2,3,6.5,5.0);
//		dao.displayClassPath();
//		dao.connect();
//		dao.createlocationList();
//		List<Location> Locations = dao.readlocationList();
//		dao.printLocations(Locations);
	}

}
