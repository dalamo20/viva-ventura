package com.vivaventura.model.domain;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.Random;
import java.util.UUID;

public class Activity implements Serializable {
    //Instance variables
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private String date;
    private String time;
    private Location location;

    //Default constructor
    public Activity(){}

    //Overloaded constructor
    public Activity(String name, String date, String time, Location location) {
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Activity(int id, String name, String date, String time, Location location) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
        this.location = location;
    }

    public Activity(int id, String name, String date, String time) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.time = time;
    }

    public Activity(String name, String location, String time) {
        // Perform null checks during object creation
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        if (time == null) {
            throw new IllegalArgumentException("Time cannot be null");
        }
        this.name = name;
        this.location = new Location(location);  //Here Location has a constructor that creates the Location object
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Integer getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity activity)) return false;
        return getId() == activity.getId() &&
                Objects.equals(getName(), activity.getName()) &&
                Objects.equals(getDate(), activity.getDate()) &&
                Objects.equals(getTime(), activity.getTime()) &&
                Objects.equals(getLocation(), activity.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getDate(), getTime(), getLocation());
    }

    @Override
    public String toString() {
        return "Activity{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", date='" + date + '\'' +
                ", time='" + time + '\'' +
                ", location=" + location +
                '}';
    }
}
