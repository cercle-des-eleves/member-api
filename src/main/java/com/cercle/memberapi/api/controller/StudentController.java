package com.cercle.memberapi.api.controller;

import com.cercle.memberapi.api.model.StudentDTO;
import com.cercle.memberapi.business.domain.Student;
import com.cercle.memberapi.business.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@Controller
@RequestMapping(path = "/student")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public Student getStudents(){
        return new Student("12","Pouzeratte","Alexis", "alexis.pouzeratte@mines-ales.org","bgdu78", ZonedDateTime.now());
    }
}
