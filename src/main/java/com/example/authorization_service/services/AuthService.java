package com.example.authorization_service.services;


import com.example.authorization_service.repository.Authorities;
import com.example.authorization_service.repository.User;
import com.example.authorization_service.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AuthService {

    private UserRepository repository;

    public AuthService(UserRepository repo){
        this.repository = repo;
    }

    public List<Authorities> getAuthorities(User user){
        return repository.getUserAuthorities(user);
    }

}
