package com.cercle.memberapi.business.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class Board extends Group{

    private List<Group> clubs;

    public Board(String id, String name, Boolean active, ZonedDateTime creationDate, List<Group> clubs) {
        super(id, name, active, creationDate);
        this.clubs = clubs;
    }

}