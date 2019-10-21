package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(discriminatorType = DiscriminatorType.STRING, name = "organization_type")
public class Organization {

    //TODO need change incremental to real UUID
    @Id
    @Column(length = 128,updatable = false, nullable = false)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    private String name;
    private Boolean active;

    @Column(updatable = false)
    private ZonedDateTime creationDate = ZonedDateTime.now();

    // à fix :/
    @ManyToOne
    private Member president;

    @ManyToMany
    private List<Member> members;
}



