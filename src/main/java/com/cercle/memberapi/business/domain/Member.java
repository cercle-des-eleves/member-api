package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

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

    public Member(String id, String lastName, String firstName, String mail, ZonedDateTime creationDate, String promotion) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.creationDate = creationDate;
        this.promotion = promotion;
    }
}
