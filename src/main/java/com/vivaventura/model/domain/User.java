package com.vivaventura.model.domain;

import java.io.Serializable;
import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User implements Serializable {
    //Instance variables
    private static final long serialVersionUID = 7661657477853633935L;
    private String password;
    private String email;
    private Profile profile;
    private Subscription subscription;
    private String username;

    //Default constructor
    public User(){}

    //Overloaded constructor
    public User(String password, String email, Profile profile, Subscription subscription, String username) {
        // Perform null checks during object creation
        if (password == null) {
            throw new IllegalArgumentException("Password cannot be null");
        }
        if (email == null) {
            throw new IllegalArgumentException("Email cannot be null");
        }
        if (profile == null) {
            throw new IllegalArgumentException("Profile cannot be null");
        }
        if (subscription == null) {
            throw new IllegalArgumentException("Subscription cannot be null");
        }
        if (username == null) {
            throw new IllegalArgumentException("Username cannot be null");
        }

        this.password = password;
        this.email = email;
        this.profile = profile;
        this.subscription = subscription;
        this.username = username;
    }

    //email validation method
    public boolean validateEmail(String email){
        // Regular expression pattern for basic emails
        String emailPattern = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}$";
        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);
        // Checks if the email matches the emailPattern
        return matcher.matches();
    }

    //password validation method
    public boolean validatePassword(String password){
        // Check length of password
        if (password.length() <= 12) {
            System.out.println("Password is too short. It must be at least 12 characters long.");
            return false;
        }

        // Checking for characters in password
        boolean hasUppercase = false;
        boolean hasLowercase = false;
        boolean hasDigit = false;
        boolean hasSymbol = false;

        /* ForEach loop below takes the password & breaks each character into an array. We then iterate through that array
        checking if it meets all the criteria */
        for (char c : password.toCharArray()) {
            //Below we use methods provided by the Character Class to check properties of the characters in the array
            if (Character.isUpperCase(c)) {
                hasUppercase = true;
            } else if (Character.isLowerCase(c)) {
                hasLowercase = true;
            } else if (Character.isDigit(c)) {
                hasDigit = true;
            } else {
                // You can customize the list of symbols based on your requirements
                String symbols = "!@#$%^&*()_-+=<>?/[]{},.:;";
                if (symbols.contains(String.valueOf(c))) {
                    hasSymbol = true;
                }
            }
        }

        // Ensure there is at least one of each character type
        if (!hasUppercase) {
            System.out.println("Password is missing an uppercase letter.");
        }
        if (!hasLowercase) {
            System.out.println("Password is missing a lowercase letter.");
        }
        if (!hasDigit) {
            System.out.println("Password is missing a digit.");
        }
        if (!hasSymbol) {
            System.out.println("Password is missing a symbol.");
        }

        return hasUppercase && hasLowercase && hasDigit && hasSymbol;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Subscription getSubscription() {
        return subscription;
    }

    public void setSubscription(Subscription subscription) {
        this.subscription = subscription;
    }

    //Custom toString method
    @Override
    public String toString() {
        return "User{ " +
                "Username: '" + username + '\'' +
                ", Email: '" + email + '\'' +
                ", is Subscribed? '" + subscription + '\'' +
                " }";
    }

    //Equals method
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return password.equals(user.password) && getEmail().equals(user.getEmail()) && getProfile().equals(user.getProfile()) && getSubscription().equals(user.getSubscription()) && getUsername().equals(user.getUsername());
    }

    //Hashcode
    @Override
    public int hashCode() {
        return Objects.hash(password, getEmail(), getProfile(), getSubscription(), getUsername());
    }
}
