package com.mahmood.firstrestapi.socialmediaapi;

import com.mahmood.firstrestapi.exception.UserNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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
        User user = myService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id: " + id);
        }

        return user;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@RequestBody User user){
        User newUser = myService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }




}
