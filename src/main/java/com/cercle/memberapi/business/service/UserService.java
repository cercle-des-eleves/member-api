package com.cercle.memberapi.business.service;

import com.cercle.memberapi.business.domain.User;

public interface UserService {
    User getStudentWithID(String id);
}
