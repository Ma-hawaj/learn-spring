package com.mahmood.learn_spring.springBootHello05;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.mahmood.learn_spring.springBootHello05")
public class SpringBootHello05 {
    public static void main(String[] args) {
        SpringApplication.run(SpringBootHello05.class, args);
    }
}
