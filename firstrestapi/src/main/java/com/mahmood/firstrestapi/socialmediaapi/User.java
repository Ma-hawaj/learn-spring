package com.mahmood.firstrestapi.socialmediaapi;

import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.Size;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

@Component
public class User {

    private Integer id;

    @Size(min=2, message = "Name should have at least 2 chars")
    private String name;

    @Past(message = "Date should be in the past")
    private LocalDate birthDate;

    public User(Integer id, String name, LocalDate birthDate) {
        this.id = id;
        this.name = name;
        this.birthDate = birthDate;
    }

    public User(){

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
