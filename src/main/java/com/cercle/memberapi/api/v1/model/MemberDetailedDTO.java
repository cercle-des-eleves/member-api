package com.cercle.memberapi.api.v1.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MemberDetailedDTO {
    private String id;
    private String lastName;
    private String firstName;
    private String mail;
    private ZonedDateTime creationDate;
    private String promotion;
    private List<OrganizationDTO> organizations;
}
