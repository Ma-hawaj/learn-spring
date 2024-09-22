package com.mahmood.learn_jpa_hibernate.course.springdatajpa;

import com.mahmood.learn_jpa_hibernate.course.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourseSpringDataJpaRepository extends JpaRepository<Course, Long> {
    // jpa repository takes the class and the id type


}
