package com.mahmood.learn_spring.springBootHello05;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CurrencyConfigurationController {

    @Autowired
    private CurrencyServiceConfiguration config;

    @RequestMapping("/currency-configuration")
    public CurrencyServiceConfiguration retrieveConfiguration(){
        return config;
    }
}
