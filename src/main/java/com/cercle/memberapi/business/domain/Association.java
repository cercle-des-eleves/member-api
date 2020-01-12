package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import java.time.ZonedDateTime;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@Data
@NoArgsConstructor
@Entity
@DiscriminatorValue("Asso")
public class Association extends Organization {

    @OneToMany
    private List<Association> associations;

    @OneToMany
    private List<Board> boards;

    @OneToMany
    private List<Club> clubs;

    @Column(length = 14)
    private String siret;

    public Association(String id, String name, Boolean active, ZonedDateTime creationDate, Member president, List<Member> members, List<Association> associations,
            List<Board> boards, List<Club> clubs, String siret) {
        super(id, name, active, creationDate, president, members);
        this.associations = associations;
        this.boards = boards;
        this.clubs = clubs;
        this.siret = siret;
    }
}
