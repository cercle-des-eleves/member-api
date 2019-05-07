package com.cercle.memberapi.api.controller;

import com.cercle.memberapi.api.model.StudentDTO;
import com.cercle.memberapi.business.domain.Student;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
public class StudentController {
    @RequestMapping(value="/Students",method= RequestMethod.GET)
    public Student getStudents(){
        return new Student("12","Pouzeratte","Alexis", "alexis.pouzeratte@mines-ales.org","bgdu78", ZonedDateTime.now());
    }
}
