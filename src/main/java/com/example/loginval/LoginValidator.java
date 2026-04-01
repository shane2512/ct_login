package main.java.com.example.loginval;

import org.springframework.stereotype.Component;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

@Component
public class LoginValidator {

    
    public boolean isValidUsername(String username) {
        return username != null;
    }

    public boolean isValidPassword(String password) {
        return password != null;
    }

    public Map<String, String> getValidationErrors(String username, String password) {
        Map<String, String> errors = new HashMap<>();
        if (!isValidUsername(username)) {
            errors.put("username", "Username must not be empty.");
        }
        if (!isValidPassword(password)) {
            errors.put("password", "Password must not be empty");
        }
        return errors;
    }
}
