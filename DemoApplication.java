package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.CommandLineRunner;

import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.springframework.context.annotation.Bean;

import com.example.demo.model.Manager;
import com.example.demo.repository.ManagerRepository;

import org.springframework.beans.factory.annotation.Autowired;


@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) 
	{
		SpringApplication.run(DemoApplication.class, args);
	}


  @Autowired

  private ManagerRepository managerRepository;


  @Bean

  public CommandLineRunner loadData() {

    return args -> {

      // Pre-populate some manager data

     // ManagerRepository.save(new Manager(1L, "John Doe", "1234567890", "john.doe@example.com", "EMP001"));

     
    };

  }

}



