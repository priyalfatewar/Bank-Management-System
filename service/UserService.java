package com.example.Sprint4.service;

import com.example.Sprint4.model.User;
import com.example.Sprint4.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    // Create or Update a user (save)
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    // Get user by ID
    public Optional<User> getUserById(String id) {
        return userRepository.findById(id);
    }

    // Get all users
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    // Update user by ID
    public User updateUser(String id, User userDetails) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            User existingUser = user.get();
            existingUser.setFirstname(userDetails.getFirstname());
            existingUser.setLastname(userDetails.getLastname());
            existingUser.setEmail(userDetails.getEmail());
            existingUser.setDateofbirth(userDetails.getDateofbirth());
            existingUser.setAadharNumber(userDetails.getAadharNumber());
            existingUser.setPanNumber(userDetails.getPanNumber());
            existingUser.setPassword(userDetails.getPassword());
            existingUser.setConfirmPassword(userDetails.getConfirmPassword());
            return userRepository.save(existingUser);
        }
        return null;  // You can throw an exception or return a custom response here
    }

    // Delete user by ID
    public boolean deleteUser(String id) {
        if (userRepository.existsById(id)) {
            User existingUser = userRepository.getById(id);
            existingUser.setDeleted(true); // Soft delete
            userRepository.save(existingUser); // Save the user with the updated status
            return true; // Indicate that the deletion was successful
        }
        return false; // If the user does not exist, return false
    }

}
