package com.example.demo;

public class Owner {
    private int id;
    private String owner_name;
    private int pet_count;

    //getters should be used any time you need to get an object's properties
    //they will return the value at  this.propertyname
    // id getter
    public int getId() {
        return this.id;
    }
    // name getter
    public String getOwnerName() {
        return this.owner_name;
    }
    //pet count getter
    public int getPetCount(){
        return this.pet_count;
    }

    // setters should be used instead of directly accessing class properties
    //this way the class will modify its own props
    //passing in a variable to the setter will set it to the classes this.property value
    // setters
    public void setId(int id) {
        this.id = id;
    }

    public void setOwnerName(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setPetCount(int pet_count){
        this.pet_count = pet_count;
    }

    //creating an Owner object -- if passed nothing, returns object Owner with no props
    public Owner (){}
    public Owner (int id, String owner_name){ // if passed id and name, sets those to properties of new Owner
        this.id = id;
        this.owner_name = owner_name;
    }
}