package com.cercle.memberapi.business.domain;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.ZonedDateTime;
import java.util.UUID;


@AllArgsConstructor
public class Group {
    private String id;
    private String name;
    private Boolean active;
    private ZonedDateTime creationDate;
}
