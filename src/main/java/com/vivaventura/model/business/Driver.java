package com.vivaventura.model.business;

import com.vivaventura.model.domain.User;

public class Driver {
    public static void main(String[] args){
        User user = new User();
        user.setEmail("test@example.com");
        System.out.println("This is a test : " + user.getEmail());    }
}
