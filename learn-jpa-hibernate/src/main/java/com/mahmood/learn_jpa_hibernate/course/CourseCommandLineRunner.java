package com.mahmood.learn_jpa_hibernate.course;

import com.mahmood.learn_jpa_hibernate.course.jdbc.CourseJdbcRepository;
import com.mahmood.learn_jpa_hibernate.course.jpa.CourseJpaRepository;
import com.mahmood.learn_jpa_hibernate.course.springdatajpa.CourseSpringDataJpaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class CourseCommandLineRunner implements CommandLineRunner {

//    @Autowired
//    private CourseJdbcRepository myRepo;

//    @Autowired
//    private CourseJpaRepository myRepo;

    @Autowired
    private CourseSpringDataJpaRepository myRepo;

    @Override
    public void run(String... args) throws Exception {
//        myRepo.insert(new Course(1, "Learn AWS", "Mahmood"));
//        myRepo.insert(new Course(2, "Learn K8", "Mahmood JPA"));
//        myRepo.insert(new Course(3, "Learn DevOps", "Mahmood"));

        //this is only for springdatajpa
        myRepo.save(new Course(1, "Learn AWS", "Mahmood"));
        myRepo.save(new Course(2, "Learn K8", "Mahmood JPA"));
        myRepo.save(new Course(3, "Learn DevOps", "Mahmood"));

        myRepo.deleteById(1L);

        System.out.println(myRepo.findById(2L));

        System.out.println(myRepo.findAll());
        System.out.println(myRepo.count());
        System.out.println(myRepo.findByAuthor("Mahmood JPA"));
    }
}
