package com.mahmood.spring_security.student;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1, "Mahmood", 21),
            new Student(2, "Ahmed", 33),
            new Student(3, "Ali", 43)
    ));

    @GetMapping("/students")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("students/")
    public void addStudent(@RequestBody Student student){
        students.add(student);
    }


}
