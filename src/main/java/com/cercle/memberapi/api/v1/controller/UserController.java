package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;

@RestController
@RequestMapping(path = "/students")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Member getStudents(){
        return new Member("12","Pouzeratte","Alexis", "alexis.pouzeratte@mines-ales.org","bgdu78", ZonedDateTime.now());
    }

    @GetMapping("{studentId}")
    public Member getStudentWithId(@PathVariable String studentId){
        return userService.getStudentWithID(studentId);
    }
}
