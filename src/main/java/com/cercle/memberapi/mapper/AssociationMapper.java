package com.cercle.memberapi.mapper;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.AssociationDetailedDTO;
import com.cercle.memberapi.business.domain.Association;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface AssociationMapper {
    AssociationDetailedDTO toAssociationDetailedDTO(Association association);

    AssociationDTO toAssociationDTO(Association association);

    Association toAssociation(AssociationDTO associationDTO);

    Association toAssociation(AssociationDetailedDTO associationDTO);
}
