package com.scaler.bookmyshowv1.controllers;

import com.scaler.bookmyshowv1.dtos.CreateUserDto;
import com.scaler.bookmyshowv1.models.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    @PostMapping
    public User createUser(@RequestBody CreateUserDto request){
        System.out.println("Creating User: "+request.getEmail());
        return null;
    }
}
