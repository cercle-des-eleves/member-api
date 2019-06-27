package com.cercle.memberapi.business.domain;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.time.ZonedDateTime;




@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@DiscriminatorValue("Club")
public class Club extends Group {

    public Club(String id, String name, Boolean active, ZonedDateTime creationDate) {
        super(id, name, active, creationDate);
    }
}
