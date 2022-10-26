package com.example.authorization_service.repository;


import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;


public class User {

    @NotBlank
    @Size(min = 2, max = 30)
    private final String name;
    @NotBlank
    @Size(min = 3, max = 20)
    private final String password;

    public User(String name, String pass){
        this.name = name;
        this.password = pass;
    }

    public String getName(){
        return this.name;
    }
    public String getPassword(){
        return this.password;
    }
}
