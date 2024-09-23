package com.mahmood.firstwebapp.login;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    @RequestMapping("login")
    public String loginPage(@RequestParam String name, ModelMap model){

        // this is used to inject variables to the jsp
        model.put("name", name);
        System.out.println(name);
        return "login";
    }
}
