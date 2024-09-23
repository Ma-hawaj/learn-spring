package com.mahmood.firstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private AuthenticationService auth;

    @RequestMapping(value="login", method = RequestMethod.GET)
    public String loginPage(){
        return "login";
    }

    @RequestMapping(value="login", method = RequestMethod.POST)
    public String welcomePage(@RequestParam String name, String password, ModelMap model){

        if(auth.authenticate(name, password)){
            // this is used to inject variables to the jsp
            model.put("name", name);
            model.put("password", password);
            return "welcome";
        }
        return "login";
    }
}
