package com.vivaventura.model.domain;

import java.io.Serializable;
import java.sql.Time;
import java.util.Date;
import java.util.Objects;
import java.util.UUID;

public class Activity implements Serializable {
    //Instance variables
    private static final long serialVersionUID = 1L;
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

    //Custom toString method

    @Override
    public String toString() {
        return "Activity{" +
                "Activity='" + name + '\'' +
                ", Date=" + date +
                ", Time=" + time +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Activity activity)) return false;
        return Objects.equals(getName(), activity.getName()) && Objects.equals(getDate(), activity.getDate()) && Objects.equals(getTime(), activity.getTime()) && Objects.equals(getLocation(), activity.getLocation());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDate(), getTime(), getLocation());
    }
}
