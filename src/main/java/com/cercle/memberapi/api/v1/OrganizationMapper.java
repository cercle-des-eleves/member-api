package com.cercle.memberapi.api.v1;

import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDetailedDTO;
import com.cercle.memberapi.business.domain.Organization;
import org.springframework.stereotype.Component;

import java.util.ArrayList;


@Component
public class OrganizationMapper {

    public OrganizationDetailedDTO toOrganizationDetailedDTO(Organization organization) {
        return new OrganizationDetailedDTO(
                organization.getId(),
                organization.getName(),
                organization.getActive(),
                organization.getCreationDate(),
                organization.getPresident(),
                organization.getMembers());
    }

    public OrganizationDTO toOrganizationDTO(Organization organization) {
        return new OrganizationDTO(
            organization.getId(),
            organization.getName(),
            organization.getActive(),
            organization.getCreationDate(),
            organization.getPresident());
    }

    public Organization toOrganization(OrganizationDetailedDTO groupDTO) {
        return new Organization(
                groupDTO.getId(),
                groupDTO.getName(),
                groupDTO.getActive(),
                groupDTO.getCreationDate(),
                groupDTO.getPresident(),
                groupDTO.getMembers());
    }

    public Organization toOrganization(OrganizationDTO groupDTO) {
        return new Organization(
            groupDTO.getId(),
            groupDTO.getName(),
            groupDTO.getActive(),
            groupDTO.getCreationDate(),
            groupDTO.getPresident(),
            new ArrayList<>());
    }
}
