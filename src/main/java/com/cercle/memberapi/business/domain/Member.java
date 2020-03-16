package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.ZonedDateTime;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Member {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true, nullable = false,length = 40)
    @Type(type="uuid-char")
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

    @ManyToMany(mappedBy = "members", fetch = FetchType.EAGER)
    private Set<Association> associations = new HashSet<>();

    @ManyToMany(mappedBy = "members", fetch = FetchType.EAGER)
    private Set<Board> boards = new HashSet<>();

    @ManyToMany(mappedBy = "members", fetch = FetchType.EAGER)
    private Set<Club> clubs = new HashSet<>();
}
