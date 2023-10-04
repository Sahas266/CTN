package org.ccode.asset.ctn.image.rest.services;

import java.io.Serializable;

public class CTNImage implements Serializable {
	private static final long serialVersionUID = 1L;
	private int id;
	private String firstName;
	private String lastName;
	private String grade;

	public CTNImage() {
	}

	public CTNImage(int id, String fName, String lName, String grade) {
		this.id = id;
		this.firstName = fName;
		this.lastName = lName;
		this.grade = grade;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}
}