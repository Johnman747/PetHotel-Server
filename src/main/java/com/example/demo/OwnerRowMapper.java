package com.example.demo;

import com.example.demo.Owner;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class OwnerRowMapper implements RowMapper<Owner> {
    @Override //says that this can override what is callig it and throw an error?
    public Owner mapRow(ResultSet res, int rowNum) throws SQLException {
        //maps over the result set sent back from the database, and creates an
        //Owner object, sets the properties of the owner object below, then returns it
        Owner owner = new Owner();
        owner.setId(res.getInt("id"));
        owner.setOwnerName(res.getString("owner_name"));
        // owner.setPetCount(res.getInt("pet_count"));
        return owner;
    }
}