package com.vivaventura.model.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.UUID;

public class Profile implements Serializable {
    //Instance variables
    private static final long serialVersionUID = 1L;
    private String name;
    private String phoneNumber;
    private String location;
    private boolean twoFactorAuthenticationEnabled;

    //Default constructor
    public Profile(){}

    //Overloaded constructor
    public Profile(String name, String phoneNumber, String location, boolean twoFactorAuthenticationEnabled) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.location = location;
        this.twoFactorAuthenticationEnabled = twoFactorAuthenticationEnabled;
    }

    //validate fields are not null
    public Profile(String name, String location) {
        // Perform null checks during object creation
        if (name == null) {
            throw new IllegalArgumentException("Name cannot be null");
        }
        if (location == null) {
            throw new IllegalArgumentException("Location cannot be null");
        }

        this.name = name;
        this.location = location;
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
                '}';
    }

    //Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Profile profile)) return false;
        return isTwoFactorAuthenticationEnabled() == profile.isTwoFactorAuthenticationEnabled() && getName().equals(profile.getName()) && Objects.equals(getPhoneNumber(), profile.getPhoneNumber()) && getLocation().equals(profile.getLocation());
    }

    //Hashcode: name, location are non null fields
    @Override
    public int hashCode() {
        return Objects.hash(getName(), getPhoneNumber(), getLocation(), isTwoFactorAuthenticationEnabled());
    }
}
