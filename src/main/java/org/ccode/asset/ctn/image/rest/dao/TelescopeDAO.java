package org.ccode.asset.ctn.image.rest.dao;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.ccode.asset.ctn.image.rest.models.Telescope;

public class TelescopeDAO {
	public List<Telescope> telescopeList = new ArrayList<Telescope>();

	public static Connection connection;

	public void connect() {
		try {
			Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
			DriverManager.registerDriver(new org.apache.derby.jdbc.EmbeddedDriver());
			connection = DriverManager.getConnection("jdbc:derby:c:\\temp\\myDB;create=true");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		catch (SQLException e) {
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

	public List<Telescope> readTelescopeList() {
		// Retrieve data from the database.
		connect();
		Statement statement;
		try {
			statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery("SELECT * FROM Telescope");
			// Iterate over the ResultSet and print the results.
			while (resultSet.next()) {
				Telescope telescope = new Telescope();
				telescope.setName(resultSet.getString("NAME"));
				telescope.setTelescopeType(Integer.parseInt(resultSet.getString("TYPE")));
				telescope.setId(Integer.parseInt(resultSet.getString("ID")));
				telescope.setLocation(Integer.parseInt(resultSet.getString("LOCATION")));
				telescope.setAperture(Double.parseDouble(resultSet.getString("APERTURE")));
				telescope.setFieldOfView(Double.parseDouble(resultSet.getString("FIELDOFVIEW")));
				telescopeList.add(telescope);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		printTelescopes(telescopeList);
		return telescopeList;
	}

	public void addTelescope(String name, int location, int type, double aperture, double fieldView) {
		connect();
		Statement statement;
		String query = "INSERT INTO Telescope (name, location, type, aperture, fieldofview) values (" + "'" + name + "', " +
				+ location + ", " + type + ", " + aperture + ", " + fieldView + ")";
		System.out.println(query);
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateTelescope(int id, int location) {
		connect();
		Statement statement;
		String query = "Update Telescope SET location = " + location + " where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteTelescope(int id) {
		connect();
		Statement statement;
		String query = "Delete from Telescope where id = " + id;
		try {
			statement = connection.createStatement();
			statement.executeUpdate(query);			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printTelescopes(List<Telescope> telescopesList) {
		for (Telescope t : telescopesList) {
			System.out.println(" ID:" + t.getId() + "; Name:" + t.getName() + "; Location:" + t.getLocation()
					+ ";  Type:" + t.getTelescopeType() + "; Aperture:" + t.getAperture() + "; FieldOfView:"
					+ t.getFieldOfView());
		}
	}

	public static void main(String[] args) {
		TelescopeDAO dao = new TelescopeDAO();
//		dao.updateTelescope(4,5);
		dao.addTelescope("test",2,3,6.5,5.0);
//		dao.displayClassPath();
//		dao.connect();
//		dao.createTelescopeList();
//		List<Telescope> telescopes = dao.readTelescopeList();
//		dao.printTelescopes(telescopes);
	}

}
