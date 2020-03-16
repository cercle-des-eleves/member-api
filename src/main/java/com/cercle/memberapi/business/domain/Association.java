package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.time.ZonedDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Association {

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(unique = true, nullable = false,length = 128)
    @Type(type="uuid-char")
    private UUID id;

    private String name;

    private boolean active;

    @Column(updatable = false)
    private ZonedDateTime creationDate = ZonedDateTime.now();

    @ManyToOne
    private Member president;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinTable(
            name = "association_member",
            joinColumns = {@JoinColumn(name = "association_id")},inverseJoinColumns = {@JoinColumn(name = "member_id")}
    )
    private Set<Member> members;

    @OneToMany
    private Set<Association> associations;

    @OneToMany
    private Set<Board> boards;

    @OneToMany
    private Set<Club> clubs;

    @Column(length = 14)
    private String siret;
}
