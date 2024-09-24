package com.mahmood.firstrestapi.socialmediaapi;

import com.mahmood.firstrestapi.exception.UserNotFoundException;
import jakarta.validation.Valid;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
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
    public EntityModel<User> retrieveUser(@PathVariable int id){
        User user = myService.findOne(id);
        if(user == null){
            throw new UserNotFoundException("id: " + id);
        }

        // this will add the retrieveAllUsers link to the _links
        EntityModel<User> entity = EntityModel.of(user);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
                this.getClass()).retrieveAllUsers()
        );
        entity.add(link.withRel("all-users"));

        return entity;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser = myService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        myService.deleteById(id);
    }


}
