package com.cercle.memberapi.business.domain;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.time.ZonedDateTime;
import java.util.UUID;

@EqualsAndHashCode(callSuper = true)
@Data
public class Club extends Group {

    public Club(String id, String name, Boolean active, ZonedDateTime creationDate) {
        super(id, name, active, creationDate);
    }
}
