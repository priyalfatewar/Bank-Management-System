package com.example.demo.controller;



import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Manager;

import com.example.demo.service.ManagerService;



import java.util.List;



@RestController

@CrossOrigin(origins = "http://localhost:4200") // Adjusted to allow requests from the Angular frontend

@RequestMapping("/api/managers")

public class ManagerController {



  @Autowired

  private ManagerService managerService;



  // Create or Update Manager (POST and PUT)

  @PostMapping

  public Manager saveManager(@RequestBody Manager manager) {

    return managerService.saveManager(manager); // Save manager (creates or updates)

  }



  // Get Manager by ID (GET)

  @GetMapping("/{id}")

  public Manager getManagerById(@PathVariable Long id) {

    return managerService.getManagerById(id);

  }



  // Get All Managers (GET)

  @GetMapping

  public List<Manager> getAllManagers() {

    return managerService.getAllManagers();

  }



  // Update Manager by ID (PUT)

  @PutMapping("/{id}")

  public Manager updateManagerById(@PathVariable Long id, @RequestBody Manager updatedManager) {

    return managerService.updateManagerById(id, updatedManager);

  }



  // Delete Manager by ID (DELETE)

  @DeleteMapping("/{id}")

  public Manager deleteManagerById(@PathVariable Long id) {

    return managerService.deleteManagerById(id);

  }

}