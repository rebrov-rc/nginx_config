package com.example.authorization_service.controllers;


import com.example.authorization_service.exceptions.InvalidCredentials;
import com.example.authorization_service.exceptions.UnauthorizedUser;
import com.example.authorization_service.repository.Authorities;
import com.example.authorization_service.repository.User;
import com.example.authorization_service.services.AuthService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
public class AuthController {

    private AuthService service;

    public AuthController(AuthService service){
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.GET, path = "/auth")
    public List<Authorities> auth(@Valid User user){

        if (isEmpty(user.getName()) || isEmpty(user.getPassword())){
            throw new InvalidCredentials("User name or password is empty");
        }
        List<Authorities> userAuthorities  =  this.service.getAuthorities(user);

        if(isEmpty(userAuthorities)){
            throw new UnauthorizedUser("Unknown user " + user);
        }
        return userAuthorities;
    }

    private boolean isEmpty(List<?> str){
        return str == null || str.isEmpty();
    }
    private boolean isEmpty(String str){
        return str == null || str.isEmpty();
    }

}
