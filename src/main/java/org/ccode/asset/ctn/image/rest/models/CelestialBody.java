package org.ccode.asset.ctn.image.rest.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CelestialBody implements Serializable {
	private int id;
	private String name;
	private int location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

}
