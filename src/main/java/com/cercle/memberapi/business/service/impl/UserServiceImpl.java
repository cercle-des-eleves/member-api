package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.service.UserService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public Member getStudentWithID(String id) {
        return new Member(id, "Girard-Blanc", "Bastien", "b.girardblanc@mines-ales.org", "bgdu19",ZonedDateTime.now());
    }
}
