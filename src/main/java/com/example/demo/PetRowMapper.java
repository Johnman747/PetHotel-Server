package com.example.demo;

import com.example.demo.Pet;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class PetRowMapper implements RowMapper<Pet> {
    //RowMapper is used to map over the rows returned from our database query
    @Override
    public Pet mapRow(ResultSet res, int rowNum) throws SQLException {
        //for each row, create a new Pet and set the variables as below, then return it
        Pet pet = new Pet();
        pet.setId(res.getInt("id"));
        pet.setOwnerId(res.getInt("owner_id"));
        pet.setPetName(res.getString("pet_name"));
        pet.setOwnerName(res.getString("owner_name"));
        pet.setBreed(res.getString("breed"));
        pet.setColor(res.getString("color"));
        // pet.setUrl(res.getString("url"));
        pet.setCheckedInStatus(res.getBoolean("is_checked_in"));
        pet.setCheckedInDate(res.getDate("checked_in_date"));
        return pet;
    }
}