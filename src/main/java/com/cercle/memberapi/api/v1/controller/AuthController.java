package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.authentication.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    /**
     * Create a new association
     *
     * @param user
     * @return
     */
    @PostMapping
    public boolean saveUser(User user) {

        return true;
        //return userRepository.save(user);
        //return new ResponseEntity<>(result, HttpStatus.OK);
    }
}
