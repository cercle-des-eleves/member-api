package com.cercle.memberapi.business.domain;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity()
public class Member {

    @Id
    @Column(length = 128, updatable = false, nullable = false, name = "member_id")
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String id;
    private String lastName;
    private String firstName;
    private String mail;
    private ZonedDateTime creationDate;
    //TODO Transformer en objet
    private String promotion;

    @JsonIgnore
    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private List<Organization> organizations;

    public Member(String id, String lastName, String firstName, String mail, ZonedDateTime creationDate,
                  String promotion) {
        this.id = id;
        this.lastName = lastName;
        this.firstName = firstName;
        this.mail = mail;
        this.creationDate = creationDate;
        this.promotion = promotion;
    }
}
