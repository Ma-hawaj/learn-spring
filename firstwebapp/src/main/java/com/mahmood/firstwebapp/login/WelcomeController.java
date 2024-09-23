package com.mahmood.firstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.SessionAttributes;

@Controller
@SessionAttributes("name") // this should be available in every class that uses the session
public class WelcomeController {

    @RequestMapping(value="/")
    public String welcomePage(ModelMap model){

            // this is used to inject variables to the jsp
            model.put("name", "Mahmood");
            return "welcome";
    }
}
