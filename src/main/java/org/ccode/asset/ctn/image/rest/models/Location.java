package org.ccode.asset.ctn.image.rest.models;

import java.io.Serializable;

public class Location implements Serializable {
	private int id;
    private Double celestialLongitude;
    private Double celestialLatitude;

    public Location() {
    }

    public Location(int id, Double celestialLongitude, Double celestialLatitude) {
    	this.id = id;
        this.celestialLongitude = celestialLongitude;
        this.celestialLatitude = celestialLatitude;
    }

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

    public Double getCelestialLongitude() {
        return celestialLongitude;
    }

    public void setCelestialLongitude(Double celestialLongitude) {
        this.celestialLongitude = celestialLongitude;
    }

    public Double getCelestialLatitude() {
        return celestialLatitude;
    }

    public void setCelestialLatitude(Double celestialLatitude) {
        this.celestialLatitude = celestialLatitude;
    }

    @Override
    public String toString() {
        return "Location{" +
                ", celestialLongitude=" + celestialLongitude +
                ", celestialLatitude=" + celestialLatitude +
                '}';
    }
}