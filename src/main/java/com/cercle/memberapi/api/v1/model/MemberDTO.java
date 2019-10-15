package com.cercle.memberapi.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDTO {
    private String id;
    private String lastName;
    private String firstName;
    private String mail;
    private String password;
    private ZonedDateTime creationDate;
}
