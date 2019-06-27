package com.cercle.memberapi.api.model;

import java.time.ZonedDateTime;
import java.util.UUID;

public class StudentDTO {
    private UUID uuid;
    private String name;
    private String firstName;
    private String mail;
    private String password;
    private ZonedDateTime createDate;
}
