package com.cercle.memberapi.api.controller;

import com.cercle.memberapi.api.model.StudentDTO;
import com.cercle.memberapi.business.domain.Student;
import com.cercle.memberapi.business.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping(path = "/students")
public class StudentController {
    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping()
    public Student getStudents(){
        return new Student("12","Pouzeratte","Alexis", "alexis.pouzeratte@mines-ales.org","bgdu78", ZonedDateTime.now());
    }

    @GetMapping("{studentId}")
    public Student getStudentWithId(@PathVariable String studentId){
        return studentService.getStudentWithID(studentId);
    }
}
