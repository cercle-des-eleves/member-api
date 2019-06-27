package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;

@Data
@AllArgsConstructor
public class User {
    private String id;
    private String lastName;
    private String firstName;
    private String mail;
    private String password;
    private ZonedDateTime creationDate;
}
