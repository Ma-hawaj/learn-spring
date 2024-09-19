package com.mahmood.learn_spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App02HelloWorldSpring {
    public static void main(String[] args) {
        //1: Launch a Spring Context
        var context = new AnnotationConfigApplicationContext(HelloWorldSpringConfiguration.class);

        //2: Configure the things that Spring will manage in a configuration class

        //3: Retrieving Beans managed by spring
        // retrieving by the bean name
        System.out.println(context.getBean("name"));
        System.out.println(context.getBean("person3Parameter"));
        // retrieving by the class name
        // note that there should be only one bean that returns this class
        System.out.println(context.getBean(Address.class));
    }

}
