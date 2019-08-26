package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@Entity(name = "`user`")
public class Member {

    @Id
    @Column(length = 128,updatable = false, nullable = false)
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;
    private String lastName;
    private String firstName;
    private String mail;
    private ZonedDateTime creationDate;
    //TODO Transformer en objet
    private String promotion;

    @ManyToMany
    private List<Group> groups;
}
