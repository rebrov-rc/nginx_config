package com.example.authorization_service.repository;


import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class UserRepository {

    private List<Authorities> userAuthorities = new ArrayList<>();
    private Map<String, User> userStorage = new HashMap();

    public UserRepository(){
        User user = new User("Ivan", "123");
        this.userStorage.put(user.getName(), user);

        for (Authorities item : Authorities.values()){
            userAuthorities.add(item);
        }
    }

    public List<Authorities> getUserAuthorities(User user){

        List<Authorities> list = null;

        if (userStorage.containsKey(user.getName())){

            User user1 = userStorage.get(user.getName());
            if (user.getPassword().equals(user1.getPassword())){
                list = userAuthorities;
            }
        }

        return list;

    }

}
