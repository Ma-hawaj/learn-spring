package com.mahmood.learn_jpa_hibernate.course.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseJdbcCommandLineRunner implements CommandLineRunner {

    @Autowired
    private CourseJdbcRepository myRepo;

    @Override
    public void run(String... args) throws Exception {
        myRepo.insert(new Course(1, "Learn AWS", "Mahmood"));
        myRepo.insert(new Course(2, "Learn K8", "Mahmood"));
        myRepo.insert(new Course(3, "Learn DevOps", "Mahmood"));

        myRepo.deleteById(1);

        System.out.println(myRepo.findById(2));
    }
}
