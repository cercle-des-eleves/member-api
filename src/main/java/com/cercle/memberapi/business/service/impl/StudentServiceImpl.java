package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.model.StudentDTO;
import com.cercle.memberapi.business.domain.Student;
import com.cercle.memberapi.business.service.StudentService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class StudentServiceImpl implements StudentService {
    @Override
    public Student getStudentWithID(String id) {
        return new Student("2", "Girard-Blanc", "Bastien", "b.girardblanc@mines-ales.org", "bgdu19",ZonedDateTime.now());
    }
}
