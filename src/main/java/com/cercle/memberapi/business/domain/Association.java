package com.cercle.memberapi.business.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Asso")
public class Association extends Group{

    @OneToMany
    private List<Group> groups;

    @Column(length = 14)
    private String siret;



}