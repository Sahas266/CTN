package org.ccode.asset.ctn.image.rest.models;

import java.io.Serializable;

public class Telescope implements Serializable {
	private int id;
	private String name;
	private int location;
	private int telescopeType;
	private double aperture;
	private double fieldOfView;

	public Telescope() {
	}

	public Telescope(int id, String name, int location, int type, double aperture, double fieldOfView) {
		this.id = id;
		this.name = name;
		this.location = location;
		this.telescopeType = type;
		this.aperture = aperture;
		this.fieldOfView = fieldOfView;
	}

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

	public Integer getLocation() {
		return location;
	}

	public void setLocation(Integer location) {
		this.location = location;
	}

	public int getTelescopeType() {
		return telescopeType;
	}

	public void setTelescopeType(int telescopeType) {
		this.telescopeType = telescopeType;
	}

	public Double getAperture() {
		return aperture;
	}

	public void setAperture(Double aperture) {
		this.aperture = aperture;
	}

	public Double getFieldOfView() {
		return fieldOfView;
	}

	public void setFieldOfView(Double fieldOfView) {
		this.fieldOfView = fieldOfView;
	}

	@Override
	public String toString() {
		return "Telescope{" + "id=" + id + ", name='" + name + '\'' + ", location=" + location + ", telescopeType=" + telescopeType + ", aperture=" + aperture + ", fieldOfView=" + fieldOfView + '}';
	}
}