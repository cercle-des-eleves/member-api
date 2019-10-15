package com.cercle.memberapi.business.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
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
}