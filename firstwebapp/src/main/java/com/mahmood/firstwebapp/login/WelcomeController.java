package com.mahmood.firstwebapp.login;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // this should be available in every class that uses the session
public class WelcomeController {

    private String getLoggedUsername(){
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return auth.getName();
    }

    @RequestMapping(value="/")
    public String welcomePage(ModelMap model){

            // this is used to inject variables to the jsp
            model.put("name", getLoggedUsername());
            return "welcome";
    }
}
