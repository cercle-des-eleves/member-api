package com.cercle.memberapi.business.service;

import com.cercle.memberapi.business.domain.Member;

public interface UserService {
    Member getStudentWithID(String id);
}
