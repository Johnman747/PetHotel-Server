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
        return "Spring Boot is ready! Welcome to Java Hell!";
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

    @PostMapping("/pets") // post route tp /pets
    public void addPet(@RequestBody Pet newPet) {
        String query = "INSERT INTO pets (owner_id, pet_name, breed, color, is_checked_in) VALUES (?, ?, ?, ?, ?);";
        try {
            jdbcTemplate.update(query, newPet.getOwnerId(), newPet.getPetName(), newPet.getBreed(), newPet.getColor(), newPet.getCheckedInStatus());
            // jdbcpTemplate will pass params into ?s to santize query
        } catch (Exception error) {
            System.err.println(error);
            throw error; // throws error if unmet
        }
    }

    @PostMapping("/owners") // post route to /owners for new owner, works same as pet route above
    public void addOwner(@RequestBody Owner newOwner){
        String query = "INSERT INTO owners (owner_name) VALUES (?)";
        try {
            jdbcTemplate.update(query, newOwner.getOwnerName());
        } catch (Exception e){
            System.err.println(e);
            throw e;
        }
    }

    @PatchMapping("/pets/checked/{id}") //patch route for pet checking in/out
    public void checkInPet(@PathVariable int id) {
        String query = "UPDATE pets SET is_checked_in = NOT is_checked_in, checked_in_date = now() WHERE id = ?";
        //query text toggles checkin status and sets new checkin date to now()
        try {
            jdbcTemplate.update(query, id);
        } catch (Exception error) {
            throw error;
        }
    };

    @DeleteMapping("/pets/{id}")
        public void deletePet(@PathVariable int id) { //@Pathvariable int id accesses the
            //id param above and sets it into the variable "id" with type of int
            String query = "DELETE FROM pets WHERE id = ?;";
            try {
                jdbcTemplate.update(query, id);
            } catch (Exception e) {
                System.err.println(e);
                throw e;
            }
        }
}

