package com.example.demo.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.example.demo.model.Manager;

import com.example.demo.repository.ManagerRepository;



@Service

public class ManagerService {



  @Autowired

  private ManagerRepository managerRepository;



  // Get Manager by ID

  public Manager getManagerById(Long id) {

    return managerRepository.findById(id)

        .orElseThrow(() -> new RuntimeException("Manager not found with ID: " + id));

  }



  // Create or Update Manager

  public Manager saveManager(Manager manager) {

    return managerRepository.save(manager); // ID will be generated automatically

  }



  // Get all Managers

  public List<Manager> getAllManagers() {

    return managerRepository.findAll();

  }



  // Delete Manager by ID

  public Manager deleteManagerById(Long id) {

    Manager existingManager = getManagerById(id);

     

    existingManager.setDeleted(true);

    existingManager.setFirstName(existingManager.getFirstName());

    existingManager.setLastName(existingManager.getLastName());

    existingManager.setDepartment(existingManager.getDepartment());

    existingManager.setEmail(existingManager.getEmail());

     



    return managerRepository.save(existingManager);

  }



  // Update Manager by ID

  public Manager updateManagerById(Long id, Manager updatedManager) {

    Manager existingManager = getManagerById(id);

     

    // Update fields

    existingManager.setFirstName(updatedManager.getFirstName());

    existingManager.setLastName(updatedManager.getLastName());

    existingManager.setEmail(updatedManager.getEmail());

    existingManager.setDepartment(updatedManager.getDepartment());



    return managerRepository.save(existingManager);

  }

}





/*

 * package com.example.demo.service;

 * 

 * import java.util.List; import java.util.Optional;

 * 

 * import org.springframework.beans.factory.annotation.Autowired; import

 * org.springframework.stereotype.Service;

 * 

 * import com.example.demo.model.Manager; import

 * com.example.demo.repository.ManagerRepository;

 * 

 * 

 * 

 * @Service

 * 

 * public class ManagerService {

 * 

 * 

 * 

 * @Autowired private ManagerRepository managerRepository; public Manager

 * getManagerById(Long id) { return

 * managerRepository.findById(id).orElseThrow(() -> new

 * RuntimeException("Manager not found with ID: " + id)); }

 * 

 * // Create or Update Manager public Manager saveManager(Manager manager) {

 * return managerRepository.save(manager); }

 * 

 * // Get all Managers public List<Manager> getAllManagers() { return

 * managerRepository.findAll(); }

 * 

 * 

 * // Get a single Manager by ID public Optional<Manager> getManagerById(Long

 * id) { return managerRepository.findById(id); }

 * 

 * // Delete Manager public void deleteManager(Long id) {

 * managerRepository.deleteById(id); }

 * 

 * 

 * public Manager updateManager(Long id, Manager updatedManager) {

 * 

 * Manager existingManager = getManagerById(id);

 * 

 * 

 * 

 * existingManager.setName(updatedManager.getName());

 * 

 * existingManager.setMobileNumber(updatedManager.getMobileNumber());

 * 

 * existingManager.setEmailAddress(updatedManager.getEmailAddress());

 * 

 * existingManager.setEmployeeId(updatedManager.getEmployeeId());

 * 

 * 

 * 

 * return managerRepository.save(existingManager);

 * 

 * }

 * 

 * }

 */

