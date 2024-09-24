package com.mahmood.firstrestapi.socialmediaapi;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    private static final List<User> users = new ArrayList<>();

    private static int usersCount = 3;

    static {
        users.add(new User(1, "Adam", LocalDate.now().minusYears(25)));
        users.add(new User(2, "Mahmood", LocalDate.now().minusYears(25)));
        users.add(new User(3, "Ahmed", LocalDate.now().minusYears(25)));
    }

    public List<User> findAll(){
        return users;
    }

    public User save(User user){
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().orElse(null);
    }

    public void deleteById(int id){
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        users.removeIf(predicate);
    }



}
