package com.cercle.memberapi.api.v1.model;

import com.cercle.memberapi.business.domain.Member;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToMany;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrganizationDTO {
    private String id;
    private String name;
    private Boolean active;
    private ZonedDateTime creationDate;
    private Member president;
    private List<Member> members;
}
