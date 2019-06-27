package com.cercle.memberapi.business.service;

import com.cercle.memberapi.api.model.StudentDTO;
import com.cercle.memberapi.business.domain.Student;

public interface StudentService {
    Student getStudentWithID(String id);
}
