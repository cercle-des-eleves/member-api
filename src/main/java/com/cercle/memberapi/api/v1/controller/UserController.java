package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Collections;

@RestController
@RequestMapping(path = "/students")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public Member getStudents(){
        //TODO Pour montrer ce que ça retourne en JSON mais à effectuer
        return new Member("12","Pouzeratte","Alexis", "alexis.pouzeratte@mines-ales.org", ZonedDateTime.now(),"INFRES 11");
    }

    @GetMapping("{studentId}")
    public Member getStudentWithId(@PathVariable String studentId){

        return userService.getStudentWithID(studentId);
    }
}