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
import java.util.Optional;

@RestController
public class UserController {

    private final UserDaoService UserService;

    private final PostRepository postRepo;

    public UserController(UserDaoService service, PostRepository postRepo){
        this.UserService = service;
        this.postRepo = postRepo;
    }

    @GetMapping(path = "/users")
    public List<User> retrieveAllUsers(){
        return UserService.findAll();
    }


    @GetMapping(path = "/users/{id}")
    public EntityModel<User> retrieveUser(@PathVariable int id){
//        User user = myService.findOne(id);
        Optional<User> user = UserService.findById(id);
//        if(user == null){
//            throw new UserNotFoundException("id: " + id);
//        }

        if(user.isEmpty()){
            throw new UserNotFoundException("id: " + id);
        }

        // this will add the retrieveAllUsers link to the _links
//        EntityModel<User> entity = EntityModel.of(user);
        EntityModel<User> entity = EntityModel.of(user.get());
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(
                this.getClass()).retrieveAllUsers()
        );
        entity.add(link.withRel("all-users"));

        return entity;
    }

    @PostMapping(path = "/users")
    public ResponseEntity<User> createUser(@Valid @RequestBody User user){
        User newUser = UserService.save(user);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(newUser.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


    @DeleteMapping(path = "/users/{id}")
    public void deleteUser(@PathVariable int id){
        UserService.deleteById(id);
    }

    @GetMapping(path = "/users/{id}/posts")
    public List<Post> retrievePostsForUser(@PathVariable int id){

        Optional<User> user = UserService.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: "+id);

        return user.get().getPosts();
    }

    @PostMapping(path = "/users/{id}/posts")
    public ResponseEntity<Post> addPost(@PathVariable int id,@Valid @RequestBody Post post){

        Optional<User> user = UserService.findById(id);
        if(user.isEmpty())
            throw new UserNotFoundException("id: "+id);

        post.setUser(user.get());

        Post newPost = postRepo.save(post);

        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}/")
                .buildAndExpand(newPost.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }


}
