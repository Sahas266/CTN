package org.ccode.asset.ctn.image.rest.models;

import java.io.Serializable;
import java.time.LocalDateTime;

public class CelestialEvent implements Serializable {
	private int id;
	private String event;
	private int location;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getEvent() {
		return event;
	}

	public void setEvent(String event) {
		this.event = event;
	}

	public int getLocation() {
		return location;
	}

	public void setLocation(int location) {
		this.location = location;
	}

}
