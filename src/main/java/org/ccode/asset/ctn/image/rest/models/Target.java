package org.ccode.asset.ctn.image.rest.models;

import java.io.Serializable;

public class Target implements Serializable {
    private Long id;
    private String name;
    private TargetType type;
    private Location location;

    public Target() {
    }

    public Target(Long id, String name, TargetType type, Location location) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.location = location;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TargetType getType() {
        return type;
    }

    public void setType(TargetType type) {
        this.type = type;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Target{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", location=" + location +
                '}';
    }
}