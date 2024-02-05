package com.vivaventura.model.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Itinerary implements Serializable {
    private static final long serialVersionUID = 1L;
    private int id;
    private String name;
    private List<Activity> activities;

    public Itinerary(){}

    public Itinerary(String name, List<Activity> activities) {
        this.name = name;
        this.activities = activities;
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

    public void addActivity(Activity activity) {
        this.activities.add(activity);
    }

    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "Itinerary{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", activities=" + activities +
                '}';
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
