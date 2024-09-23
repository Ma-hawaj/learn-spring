package com.mahmood.firstwebapp.login;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("login")
    public String loginPage(@RequestParam String name, ModelMap model){

        // this is used to inject variables to the jsp
        model.put("name", name);
        logger.debug("Request param is {}",name);
        return "login";
    }
}
