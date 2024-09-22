package com.mahmood.learn_jpa_hibernate.course.jpa;

import com.mahmood.learn_jpa_hibernate.course.Course;
import jakarta.persistence.EntityManager;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class CourseJpaRepository {

    @Autowired
    private EntityManager entityManager;

    public void insert(Course course){
        entityManager.merge(course);
    }
}
