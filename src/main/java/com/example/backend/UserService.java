package com.example.backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
//import io.jsonwebtoken.Jwts;
//import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public User registerUser(User user) {
        // Validate input fields
        if (user.getUsername() == null || user.getUsername().isEmpty() ||
            user.getEmail() == null || user.getEmail().isEmpty() ||
            user.getPassword() == null || user.getPassword().isEmpty() ||
            user.getFullName() == null || user.getFullName().isEmpty()) {
            throw new IllegalArgumentException("Invalid request. Please provide all required fields: username, email, password, full_name.");
        }

        // Check if username or email already exists
        if (userRepository.findByUsername(user.getUsername()) != null) {
            throw new IllegalArgumentException("The provided username is already taken. Please choose a different username.");
        }
        if (userRepository.findByEmail(user.getEmail()) != null) {
            throw new IllegalArgumentException("The provided email is already registered. Please use a different email address.");
        }

        // Other validations (e.g., password complexity, age, gender)

        // Save the user
        return userRepository.save(user);
    }

    public String generateToken(String username, String password) {
        // Validate input fields
        if (username == null || username.isEmpty() || password == null || password.isEmpty()) {
            throw new IllegalArgumentException("Missing fields. Please provide both username and password.");
        }

        // Authenticate the user (You may have a different authentication mechanism)
        User user = userRepository.findByUsername(username);
        if (user == null || !user.getPassword().equals(password)) {
            throw new IllegalArgumentException("Invalid credentials. The provided username or password is incorrect.");
        }

        // Generate and return the JWT token
        @SuppressWarnings("deprecation")
		String token = Jwts.builder()
                .setSubject(username)
                .setExpiration(new Date(System.currentTimeMillis() + 3600000)) // 1 hour expiration
                .signWith(SignatureAlgorithm.HS512, "your-secret-key")
                .compact();

        return token;
    }
}



