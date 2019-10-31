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
        String query = "SELECT owners.id, owners.owner_name, count(pets.owner_id) AS pet_count FROM owners LEFT JOIN pets ON pets.owner_id = owners.id GROUP BY owners.id ORDER BY owners.id DESC;";
        List<Owner> owners = jdbcTemplate.query(query, new OwnerRowMapper());
        //OwnerRowMapper is our handler that parses out the response from the database, creating an Owner object for each of them
        //it then assigns this list of Owners into the List<Owner> owners, and returns it
        return owners;
    }

    @RequestMapping("/pets") // get route to /pets
    public List<Pet> getAllPets () {
        String query = "SELECT pets.id, pets.pet_name, pets.breed, pets.color, pets.url, pets.is_checked_in, pets.checked_in_date, pets.owner_id, owners.owner_name FROM pets JOIN owners ON pets.owner_id = owners.id ORDER BY owners.owner_name;";
        List<Pet> pets = jdbcTemplate.query(query, new PetRowMapper());
        //PetRowMapper is the same as the ownerRowMapper above, that handles the response
        //from the database, sets it into a list of Pet objects, and returns it
        return pets;
    }
}