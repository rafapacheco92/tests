package com.example;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    
    private Login login;

    @BeforeEach
    public void setUp(){
        login = new Login("rafael", "senha123");
    }

    @Test
    public void testLoginSuccess() {
        assertTrue(login.logando("rafael", "senha123"));
    }

    @Test
    public void testLoginFailure() {
        assertFalse(login.logando("rafael", "null"));
    }

    @Test
    public void testeBloqueio(){
        assertFalse(login.logando("rafael", "1"));
        assertFalse(login.logando("rafael", "2"));
        assertFalse(login.logando("rafael", "3"));

        assertFalse(login.logando("rafael", "123"));
    }

}
