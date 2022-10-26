package com.example.authorization_service.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
public class UnauthorizedUser extends RuntimeException{
    public UnauthorizedUser(String msg){
        super(msg);
    }
}
