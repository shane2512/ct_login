package com.example.loginval.controller;

import com.example.loginval.validation.LoginValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    private LoginValidator loginValidator;

    @PostMapping("/validate-login")
    public ResponseEntity<Map<String, Object>> validateLogin(@RequestBody Map<String, String> request) {
        String username = request.get("username");
        String password = request.get("password");
        Map<String, Object> response = new HashMap<>();
        boolean isValid = loginValidator.isValidUsername(username) && loginValidator.isValidPassword(password);
        
        response.put("valid", isValid);
        if (!isValid) {
            response.put("errors", loginValidator.getValidationErrors(username, password));
        }
        return ResponseEntity.ok(response);
    }
}
