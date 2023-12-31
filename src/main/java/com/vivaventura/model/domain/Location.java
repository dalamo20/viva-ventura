package com.vivaventura.model.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Location implements Serializable {
    //Instance variables
    private static final long serialVersionUID = 1L;
    private String name;
    private String address;
    private double latitude;
    private double longitude;
    private float rating;

    //Default constructor
    public Location(){}

    //Overloaded constructor
    public Location(String name, String address, double latitude, double longitude, float rating) {
        this.name = name;
        this.address = address;
        this.latitude = latitude;
        this.longitude = longitude;
        this.rating = rating;
    }

    public Location(String name) {
        // Perform null checks during object creation
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }

        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }

    //Custom toString method
    @Override
    public String toString() {
        return "Location{ " +
                "Location name: '" + name + '\'' +
                ", Address: '" + address + '\'' +
                ", Rating: " + rating +
                " }";
    }

    //Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Location location)) return false;
        return Double.compare(location.getLatitude(), getLatitude()) == 0 && Double.compare(location.getLongitude(), getLongitude()) == 0 && Float.compare(location.getRating(), getRating()) == 0 && getName().equals(location.getName()) && Objects.equals(getAddress(), location.getAddress());
    }

    //Hashcode: name is non null field
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getAddress(), getLatitude(), getLongitude(), getRating());
    }
}
