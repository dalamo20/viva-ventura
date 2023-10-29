package com.vivaventura.model.domain;

import java.util.Objects;
import java.util.UUID;

public class Profile {
    //Instance variables
    private String name;
    private String phoneNumber;
    private String location;
    private boolean twoFactorAuthenticationEnabled;
    private UUID id;

    //Default constructor
    public Profile(){}

    //Overloaded constructor
    public Profile(String name, String phoneNumber, String location, boolean twoFactorAuthenticationEnabled, UUID id) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.twoFactorAuthenticationEnabled = twoFactorAuthenticationEnabled;
        this.id = id;
    }

    //validate fields are not null
    public Profile(String name, String location, UUID id) {
        // Perform null checks during object creation
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        this.name = name;
        this.location = location;
        this.id = id;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isTwoFactorAuthenticationEnabled() {
        return twoFactorAuthenticationEnabled;
    }

    public void setTwoFactorAuthenticationEnabled(boolean twoFactorAuthenticationEnabled) {
        this.twoFactorAuthenticationEnabled = twoFactorAuthenticationEnabled;
    }

    //Custom toString method
    @Override
    public String toString() {
        return "Profile{" +
                "name='" + name + '\'' +
                ", user id=" + id +
                '}';
    }

    //Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile profile)) return false;
        return isTwoFactorAuthenticationEnabled() == profile.isTwoFactorAuthenticationEnabled() && getName().equals(profile.getName()) && Objects.equals(getPhoneNumber(), profile.getPhoneNumber()) && getLocation().equals(profile.getLocation()) && getId().equals(profile.getId());
    }

    //Hashcode: name, location and id are non null fields
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhoneNumber(), getLocation(), isTwoFactorAuthenticationEnabled(), getId());
    }
}
