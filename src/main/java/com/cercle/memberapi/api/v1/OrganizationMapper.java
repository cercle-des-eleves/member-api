package com.cercle.memberapi.api.v1;

import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Organization;
import org.springframework.stereotype.Component;


@Component
public class OrganizationMapper {

    public OrganizationDTO toGroupDTO(Organization organization) {
        return new OrganizationDTO(
                organization.getId(),
                organization.getName(),
                organization.getActive(),
                organization.getCreationDate(),
                organization.getPresident(),
                organization.getMembers());
    }

    public Organization toGroup(OrganizationDTO groupDTO) {
        return new Organization(
                groupDTO.getId(),
                groupDTO.getName(),
                groupDTO.getActive(),
                groupDTO.getCreationDate(),
                groupDTO.getPresident(),
                groupDTO.getMembers());
    }
}
