package com.cercle.memberapi.api.v1.model;


import lombok.Data;

import java.util.List;

@Data
public class GroupsDTO {
    private List<GroupDTO> groups;

    public GroupsDTO(List<GroupDTO> groups) {
        this.groups = groups;
    }
}
