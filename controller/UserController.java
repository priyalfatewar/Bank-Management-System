package com.example.Sprint4.controller;

import com.example.Sprint4.model.User;
import com.example.Sprint4.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@RestController
@CrossOrigin(origins = "http://localhost:4200", methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE, RequestMethod.OPTIONS}) 

@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    // Register or Update User
    @PostMapping("/register")
    public ResponseEntity<User> createOrUpdateUser(@RequestBody User user) {
        // Check if the user exists for update
    	user.setSsnid(generateRandomSSNId());
        Optional<User> existingUser = userService.getUserById(user.getSsnid());
        if (existingUser.isPresent()) {
            // Update user if exists
            User updatedUser = userService.updateUser(user.getSsnid(), user);
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            // Create new user if not exists
        	user.setDeleted(false);
            User savedUser = userService.saveUser(user);
            return new ResponseEntity<>(savedUser, HttpStatus.CREATED);
        }
    }
    private String generateRandomSSNId() {
        String randomSSN = "SSN" + String.format("%09d", new Random().nextInt(1000000000));
        return randomSSN;
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") String id) {
        Optional<User> user = userService.getUserById(id);
        if (user.isPresent()) {
            return new ResponseEntity<>(user.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Get all users
    @GetMapping
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @PutMapping("/update")
    public ResponseEntity<User> updateUser (@RequestBody User userDetails) {
    	
        User updatedUser = userService.updateUser(userDetails.getSsnid(), userDetails);
        if (updatedUser != null) {
            return new ResponseEntity<>(updatedUser, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }



    // Delete user by ID
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteUser(@PathVariable("id") String id) {
        boolean isDeleted = userService.deleteUser(id);
        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // Exception handler for invalid data (optional)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<String> handleException(Exception e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
