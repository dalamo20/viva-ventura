package com.vivaventura.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Itinerary implements Serializable {
    //Instance variables
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private List<Activity> activities;

    //Default constructor
    public Itinerary(){}

    //Overloaded constructor
    public Itinerary(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
        generateId();
    }

    public Itinerary(int id, String name) {
        this.id = id;
        this.name = name;
        this.activities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activities=" + activities +
                '}';
    }

    public void addActivity(Activity activity) {
        if (activities == null) {
            activities = new ArrayList<>();
        }
        //add activity to the list
        activities.add(activity);
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    //Here I am going to generate the random id's
    //using Math.abs to get positive numbers only
    public int generateId() {
        if (id == 0) {
            Random rand = new Random();
            id = Math.abs(rand.nextInt());
        }
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Itinerary itinerary = (Itinerary) o;
        return getId() == itinerary.getId() &&
                Objects.equals(getName(), itinerary.getName()) &&
                Objects.equals(getActivities(), itinerary.getActivities());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getActivities());
    }
}
