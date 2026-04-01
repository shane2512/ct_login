package com.example.loginval.validation;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;

@Component
public class LoginValidator {

    public boolean isValidUsername(String username) {
        return username != null && username.length() >= 3 && username.length() <= 20;
    }

    public boolean isValidPassword(String password) {
        return password != null && password.length() >= 6;
    }

    public Map<String, String> getValidationErrors(String username, String password) {
        Map<String, String> errors = new HashMap<>();
        if (!isValidUsername(username)) {
            errors.put("username", "Username must be 3-20 characters long.");
        }
        if (!isValidPassword(password)) {
            errors.put("password", "Password must be at least 6 characters long.");
        }
        return errors;
    }
}
