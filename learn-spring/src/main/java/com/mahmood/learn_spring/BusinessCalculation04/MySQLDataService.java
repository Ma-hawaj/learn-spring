package com.mahmood.learn_spring.BusinessCalculation04;

import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

// @Component can be replaced with @Named
@Component
@Scope(value= ConfigurableBeanFactory.SCOPE_PROTOTYPE)
// this annotation set the scope of the bean as prototype which
// means that every time this bean is called it will return a new one
public class MySQLDataService implements DataService{
    public int[] retrieveData(){
        return new int[] { 11, 22, 33, 44, 55 };
    }

    @PostConstruct
    public void initialize(){
        System.out.println("This will run just after initialization");
    }
}
