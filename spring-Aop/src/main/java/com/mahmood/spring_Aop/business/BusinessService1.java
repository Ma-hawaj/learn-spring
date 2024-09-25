package com.mahmood.spring_Aop.business;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessService1 {

    @Autowired
    private DataService1 dataService1;

    public int calculateMax(){
        int[] data = dataService1.retrieveData();

//        throw new RuntimeException("My exception");
        return Arrays.stream(data).max().orElse(0);
    }

    
}

