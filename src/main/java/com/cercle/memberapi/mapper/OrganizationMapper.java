package com.cercle.memberapi.mapper;

import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDetailedDTO;
import com.cercle.memberapi.business.domain.Organization;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface OrganizationMapper {
    OrganizationDetailedDTO toOrganizationDetailedDTO(Organization organization);

    OrganizationDTO toOrganizationDTO(Organization organization);

    Organization toOrganization(OrganizationDetailedDTO groupDTO);

    Organization toOrganization(OrganizationDTO groupDTO);
}
