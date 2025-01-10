package com.example.Sprint4.repository;

import com.example.Sprint4.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    // You can define custom queries if needed, e.g., to find by email
    User findByEmail(String email);
}
