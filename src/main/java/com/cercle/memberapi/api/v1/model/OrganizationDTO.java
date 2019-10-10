package com.cercle.memberapi.api.v1.model;


import lombok.Data;

import java.util.List;

@Data
public class OrganizationDTO {
    private List<GroupDTO> organizations;

    public OrganizationDTO(List<GroupDTO> organizations) {
        this.organizations = organizations;
    }
}
