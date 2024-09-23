package com.mahmood.firstwebapp.login;

import org.springframework.stereotype.Service;

@Service
public class AuthenticationService {

    public boolean authenticate(String username, String pass){
        return username.equalsIgnoreCase("ma.hawaj") && pass.equalsIgnoreCase("mah");
    }
}
