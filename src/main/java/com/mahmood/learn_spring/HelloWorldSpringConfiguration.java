package com.mahmood.learn_spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

record Person(String Name, int age, Address address){};

record Address(String street, String city){};

@Configuration
public class HelloWorldSpringConfiguration {

    @Bean
    public String name(){
        return "Mahmood";
    }

    @Bean
    public int age(){
        return 21;
    }

    // changing the bean name, now it can't be referenced by person
    @Bean(name = "mah")
    public Person person(){
        return new Person("mahmood", 21, new Address("5649", "Manama"));
    }

    @Bean
    public Address address(){
        return new Address("5649", "Manama");
    }

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address());
    }

    @Bean
    public Person person3Parameter(String name, int age, Address address){
        /*
         * this is auto wiring with parameters
         * so spring wires the parameters with
         * beans that have the same name.
         */
        return new Person(name, age, address);
    }


}
