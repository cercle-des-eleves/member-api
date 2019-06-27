package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.business.domain.User;
import com.cercle.memberapi.business.service.UserService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public User getStudentWithID(String id) {
        return new User(id, "Girard-Blanc", "Bastien", "b.girardblanc@mines-ales.org", "bgdu19",ZonedDateTime.now());
    }
}
