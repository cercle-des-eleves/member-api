package com.cercle.memberapi.business.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.List;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class Association extends Group{

    private List<Group> groups;

    public Association(String  id, String name, Boolean active, ZonedDateTime creationDate, List<Group> groups) {
        super(id, name, active, creationDate);
        this.groups = groups;
    }

}