package com.mahmood.firstrestapi.socialmediaapi;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class UserController {

    private final UserDaoService myService;

    public UserController(UserDaoService service){
        this.myService = service;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return myService.findAll();
    }

    @GetMapping(path = "/users/{id}")
    public User retrieveUser(@PathVariable int id){
        return myService.findOne(id);
    }





}
