package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.authentication.model.User;
import com.cercle.memberapi.persistence.repository.UserRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/auth")
public class AuthController {

    private UserRepository userRepository;

    public AuthController(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Create a new association
     *
     * @param user
     * @return
     */
    @PostMapping
    public boolean saveUser(User user) {
        this.userRepository.save(user);
        return true;
    }
}
