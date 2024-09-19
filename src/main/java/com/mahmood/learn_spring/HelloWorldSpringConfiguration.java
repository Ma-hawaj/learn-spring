package com.mahmood.learn_spring;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

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
    @Primary // Added this to prioritize this bean between the candidates
    public Address address1(){
        return new Address("5649", "Manama");
    }

    @Bean
    @Qualifier("notDefault")
    public Address address2(){ return new Address("north", "Muharaq");}

    @Bean
    public Person person2MethodCall(){
        return new Person(name(), age(), address1());
    }

    @Bean
    public Person person3Parameter(String name, int age, Address address2){
        /*
         * this is auto wiring with parameters
         * so spring wires the parameters with
         * beans that have the same name.
         *
         * The address will get the Address.class bean,
         * and it doesn't care about the bean name!
         */
        return new Person(name, age, address2);
    }

    @Bean
    public Person person4Parameter(String name, int age, @Qualifier("notDefault") Address address){
        return new Person(name, age, address);
    }

}
