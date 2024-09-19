package com.mahmood.learn_spring.BusinessCalculation04;

import org.springframework.stereotype.Component;

@Component
public class MySQLDataService implements DataService{
    public int[] retrieveData(){
        return new int[] { 11, 22, 33, 44, 55 };
    }
}
