package com.mahmood.learn_spring.injections03;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Component
class BusinessS {
    Dep1 dep1;
    Dep2 dep2;

    // this is constructor injection
    // this is the recommended method
    @Autowired
    public BusinessS(Dep1 dep1, Dep2 dep2){
        super();
        this.dep1 = dep1;
        this.dep2 = dep2;
    }

    /*
     * The following is setters injection
     * note that @Autowired is not mandatory
     */
//    @Autowired
//    public void setDep1(Dep1 dep){
//        this.dep1 = dep;
//    }
//
//    @Autowired
//    public void setDep2(Dep2 dep){
//        this.dep2 = dep;
//    }

    public String toString(){
        return "Using " + dep1 + " and " + dep2;
    }
}

@Component
class DepS1{

}

@Component
class DepS2{

}

@Configuration
@ComponentScan
public class SettersInjection  {
    public static void main(String[] args) {

        try(var context =
                    new AnnotationConfigApplicationContext
                            (SettersInjection.class)){


            System.out.println(context.getBean(BusinessS.class));

        }
    }
}
