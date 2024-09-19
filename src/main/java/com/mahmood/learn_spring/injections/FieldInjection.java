package com.mahmood.learn_spring.injections;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class Business {
    @Autowired
    Dep1 dep1;

    @Autowired
    Dep2 dep2;

    public String toString(){
        return "Using " + dep1 + " and " + dep2;
    }
}

@Component
class Dep1{

}

@Component
class Dep2{

}

@Configuration
@ComponentScan
public class FieldInjection  {
    public static void main(String[] args) {

//        var game = new MarioGame();
//        var gameRunner = new GameRunner(game);
//        gameRunner.run();

        try(var context =
                    new AnnotationConfigApplicationContext
                            (FieldInjection.class)){


            System.out.println(context.getBean(Business.class));

        }
    }
}
