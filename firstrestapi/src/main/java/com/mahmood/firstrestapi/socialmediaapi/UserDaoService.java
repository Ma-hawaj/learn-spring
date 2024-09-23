package com.mahmood.firstrestapi.socialmediaapi;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(25)));
        users.add(new User(2, "Mahmood", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Ahmed", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll(){
        return users;
    }

    public void save(User user){
        users.add(user);
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }



}
