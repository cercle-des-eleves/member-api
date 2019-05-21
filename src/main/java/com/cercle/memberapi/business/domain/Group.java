package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.ZonedDateTime;
import java.util.UUID;


@AllArgsConstructor
@Data
@Entity
public class Group {

    @Id
    @GeneratedValue(generator="system-uuid")
    private UUID id;


    private String name;
    private Boolean active;
    private ZonedDateTime creationDate;
}
