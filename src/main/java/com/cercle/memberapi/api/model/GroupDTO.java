package com.cercle.memberapi.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class GroupDTO {
    private String id;
    private String name;
    private Boolean active;
    private ZonedDateTime creationDate;
}
