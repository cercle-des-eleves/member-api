package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;

@Data
@AllArgsConstructor
public class Student {
    private String uuid;
    private String name;
    private String firstName;
    private String mail;
    private String password;
    private ZonedDateTime createDate;
}
