package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Asso")
public class Association extends Organization {

    @OneToMany
    private List<Organization> organizations;

    @Column(length = 14)
    private String siret;

    public Association(String id, String name, Boolean active, ZonedDateTime creationDate, Member president, List<Member> members, List<Organization> organizations, String siret) {
    }
}