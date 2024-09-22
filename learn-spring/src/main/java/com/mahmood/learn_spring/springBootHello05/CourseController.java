package com.mahmood.learn_spring.springBootHello05;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;


@RestController
public class CourseController {

    @RequestMapping("/courses")
    public List<Course> retrieveAllCourses(){
        return Arrays.asList(
                new Course(1, "AWS SAA", "me"),
                new Course(2, "AWS SAP", "me"),
                new Course(3, "KAP", "MJF"),
                new Course(4, "KAA", "MJF")
        );
    }
}
