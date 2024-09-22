package com.mahmood.learn_jpa_hibernate.course.springdatajpa;

import com.mahmood.learn_jpa_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    // jpa repository takes the class and the id type

    List<Course> findByAuthor(String author);

}
