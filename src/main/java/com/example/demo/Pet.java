package com.example.demo;
import java.util.Date;

public class Pet {
    //these are declaring the different properties that an object of type Pet can have
    //these must have a type declaration
    private int id;
    private int owner_id;
    private String name;
    private String owner_name;
    private String breed;
    private String color;
    private String url;
    private boolean is_checked_in;
    private Date checked_in_date;

    //id getter
    public int getId() {
        return this.id;
    }
    // //ownerId getter
    // public int getOwnerId() {
    //     return this.owner_id;
    // }
    //name getter
    public String getPetName() {
        return this.name;
    }
    // //owner name getter
    // public String getOwnerName() {
    //     return this.owner_name;
    // }
    // //breed getter
    // public String getBreed() {
    //     return this.breed;
    // }
    // //color getter
    // public String getColor() {
    //     return this.color;
    // }
    // //url getter
    // public String getUrl() {
    //     return this.url;
    // }
    // //checked in status getter
    // public boolean getCheckedInStatus() {
    //     return this.is_checked_in;
    // }
    // //checked in date getter
    // public Date getCheckedInDate() {
    //     return this.checked_in_date;
    // }
    //setters
    public void setId(int id) {
        this.id = id;
    }

    // public void setOwnerId(int owner_id) {
    //     this.owner_id = owner_id;
    // }

    public void setPetName(String pet_name) {
        this.name = pet_name;
    }

    // public void setOwnerName(String owner_name) {
    //     this.owner_name = owner_name;
    // }

    // public void setBreed(String breed) {
    //     this.breed = breed;
    // }

    // public void setColor(String color) {
    //     this.color = color;
    // }

    // public void setUrl(String url) {
    //     this.url = url;
    // }

    // public void setCheckedInStatus(boolean status) {
    //     this.is_checked_in = status;
    // }

    // public void setCheckedInDate(Date date) {
    //     this.checked_in_date = date;
    // }
    //creating a Pet object -- if passed nothing, returns a Pet object with no properties
    public Pet() {}

    //if passed the variables in the (), assigns them to properties below
    public Pet(int id,String pet_name) {
        this.id = id;
        // this.owner_id = owner_id;
        this.name = pet_name;
        // this.breed = breed;
        // this.color = color;
        // this.url = url;
        // this.is_checked_in = is_checked_in;
        // this.checked_in_date = checked_in_date;
    }

}