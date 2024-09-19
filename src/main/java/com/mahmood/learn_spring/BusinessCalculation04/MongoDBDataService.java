package com.mahmood.learn_spring.BusinessCalculation04;

import jakarta.annotation.PreDestroy;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

//@Component
@Repository // for class that interact with the database
@Primary
@Lazy // Lazy annotations initializes the class just when it being used
public class MongoDBDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] { 1, 2, 3, 4, 5 };
    }

    @PreDestroy
    public void cleanup(){
        System.out.println("This is before mongoDB is destroyed");
    }
}
