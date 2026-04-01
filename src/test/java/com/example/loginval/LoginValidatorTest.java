package com.example.loginval;

import com.example.loginval.validation.LoginValidator;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class LoginValidatorTest {

    @Autowired
    private LoginValidator loginValidator;

    @Test
    void validUsername() {
        assertTrue(loginValidator.isValidUsername("test.user123"));
    }

    @Test
    void invalidUsername() {
        assertFalse(loginValidator.isValidUsername("ab"));
    }

    @Test
    void validPassword() {
        assertTrue(loginValidator.isValidPassword("Test123!"));
    }

    @Test
    void invalidPassword() {
        assertFalse(loginValidator.isValidPassword("weak"));
    }

    @Test
    void getValidationErrors() {
        Map<String, String> errors = loginValidator.getValidationErrors("ab", "weak");
        assertTrue(errors.containsKey("username"));
        assertTrue(errors.containsKey("password"));
    }
}
