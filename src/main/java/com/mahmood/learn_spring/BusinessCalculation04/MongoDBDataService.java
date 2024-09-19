package com.mahmood.learn_spring.BusinessCalculation04;

import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
@Lazy // Lazy annotations initializes the class just when it being used
public class MongoDBDataService implements DataService{

    @Override
    public int[] retrieveData() {
        return new int[] { 1, 2, 3, 4, 5 };
    }
}
