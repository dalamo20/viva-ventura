package com.vivaventura.model.domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class UserTest {

    @Test
    public void validateValidEmail() {
        User user = new User();
        assertTrue(user.validateEmail("test@example.com"));
        assertTrue(user.validateEmail("user.name123@example.co.uk"));
        assertTrue(user.validateEmail("john.doe123@gmail.com"));
    }

    @Test
    public void validateInvalidEmail() {
        User user = new User();
        assertFalse(user.validateEmail("invalid-email.com"));
        assertFalse(user.validateEmail("user@domain"));
        assertFalse(user.validateEmail("missing@.com"));
        assertFalse(user.validateEmail("user@@example.com"));
    }

    @Test
    public void validateValidPassword() {
        User user = new User();
        assertTrue(user.validatePassword("StrongP@ssw0rd"));
        assertTrue(user.validatePassword("AnotherStrong123!"));
    }

    @Test
    public void validateInvalidPassword() {
        User user = new User();
        assertFalse(user.validatePassword("WeakPass")); // Too short
        assertFalse(user.validatePassword("nopunctuation123")); // Missing symbol
        assertFalse(user.validatePassword("nosymbolsORdigits")); // Missing uppercase, symbol, and digit
    }
}