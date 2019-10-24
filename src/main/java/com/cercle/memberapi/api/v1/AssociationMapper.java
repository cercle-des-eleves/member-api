package com.cercle.memberapi.api.v1;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.AssociationDetailedDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Organization;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.stream.Collectors;

@Component
public class AssociationMapper {
    private MemberMapper memberMapper;
    private OrganizationMapper organizationMapper;

    public AssociationMapper(MemberMapper memberMapper, OrganizationMapper organizationMapper) {
        this.memberMapper = memberMapper;
        this.organizationMapper = organizationMapper;
    }

    public AssociationDetailedDTO toAssociationDetailedDTO(Association association) {
        return new AssociationDetailedDTO(
                association.getId(),
                association.getName(),
                association.getActive(),
                association.getCreationDate(),
                association.getPresident(),
                association.getMembers().stream().map(memberMapper::toMemberDTO).collect(Collectors.toList()),
                association.getOrganizations().stream().map(organizationMapper::toOrganizationDTO).collect(Collectors.toList()),
                association.getSiret()
        );
    }

    public AssociationDTO toAssociationDTO(Association association) {
        return new AssociationDTO(
            association.getId(),
            association.getName(),
            association.getActive(),
            association.getCreationDate(),
            association.getPresident(),
            association.getSiret()
        );
    }

    public Association toAssociation(AssociationDTO associationDTO) {
        return new Association(
                associationDTO.getId(),
                associationDTO.getName(),
                associationDTO.getActive(),
                associationDTO.getCreationDate(),
                associationDTO.getPresident(),
                new ArrayList<>(),
                new ArrayList<>(),
                associationDTO.getSiret()
        );
    }

    public Association toAssociation(AssociationDetailedDTO associationDTO) {
        return new Association(
            associationDTO.getId(),
            associationDTO.getName(),
            associationDTO.getActive(),
            associationDTO.getCreationDate(),
            associationDTO.getPresident(),
            associationDTO.getMembers().stream().map(memberMapper::toMember).collect(Collectors.toList()),
            associationDTO.getOrganizations().stream().map(organizationMapper::toOrganization).collect(Collectors.toList()),
            associationDTO.getSiret()
        );
    }
}
