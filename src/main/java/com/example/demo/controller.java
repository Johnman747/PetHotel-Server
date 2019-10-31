package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class controller {
    @Autowired // autowired sets jdbc template for injecting settings into routes
    JdbcTemplate jdbcTemplate;

    @RequestMapping("/") // get route to '/', just used to confirm connection to server
    public String index(){
        return "Spring Boot is ready!";
    }

    @RequestMapping("/owners") // get route to /owners
    public List<Owner> getAllOwners (){ // creates list object containing Owner objects
        String query = "SELECT * FROM owners;";
        List<Owner> owners = jdbcTemplate.query(query, new OwnerRowMapper());
        //OwnerRowMapper is our handler that parses out the response from the database, creating an Owner object for each of them
        //it then assigns this list of Owners into the List<Owner> owners, and returns it
        return owners;
    }

    @RequestMapping("/pets")
    public List<Pet> getAllPets (){
        String query = "SELECT * FROM pets;";
        List<Pet> pets = jdbcTemplate.query(query, new PetRowMapper());
        return pets;
    }
}