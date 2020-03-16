package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @Column(updatable = false, nullable = false)
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    private String lastName;

    private String firstName;

    @Email
    private String email;

    @CreationTimestamp
    private ZonedDateTime creationDate;

    @UpdateTimestamp
    private ZonedDateTime updatedDate;

    private String promotion;

    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private Set<Association> associations;

    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private Set<Board> boards;

    @ManyToMany(mappedBy = "members", fetch = FetchType.LAZY)
    private Set<Club> clubs;
}
