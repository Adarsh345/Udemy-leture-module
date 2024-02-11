package com.adarsh.learing.controller;

import com.adarsh.learing.model.Student;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(path = "/student")
public class StudentController {

    List<Student> students = new ArrayList<>(List.of(
            new Student(1,"Adarsh tripathi","java"),
            new Student(2,"Shivam","JS"),
            new Student(2,"Raj","Block chain")
    ));


    @GetMapping(path = "/")
    public List<Student> getStudents(){
        return students;
    }

    @PostMapping("/")
    public void addStudent(@RequestBody Student student){
         students.add(student);
    }

    @GetMapping("/csrf-token")
    public CsrfToken getCsrfToken(HttpServletRequest request){
        return (CsrfToken) request.getAttribute("_csrf");
    }
}
