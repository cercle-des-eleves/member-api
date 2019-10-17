package com.cercle.memberapi.api.v1;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Organization;
import org.springframework.stereotype.Component;

@Component
public class AssociationMapper {

    public AssociationDTO toAssociationDTO(Association association) {
        return new AssociationDTO(
                association.getId(),
                association.getName(),
                association.getActive(),
                association.getCreationDate(),
                association.getPresident(),
                association.getMembers(),
                association.getOrganizations(),
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
                associationDTO.getMembers(),
                associationDTO.getOrganizations(),
                associationDTO.getSiret()
        );
    }
}
