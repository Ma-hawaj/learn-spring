package com.mahmood.learn_spring.BusinessCalculation04;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.Arrays;

//@Component
@Service // for a class that have business logic
public class BusinessCalculationService {

    // @Autowired can be replaced with @Inject
    @Autowired
    DataService myData;

    public int findMax(){
        return Arrays.stream(myData.retrieveData()).max().orElse(0);
    }

}
