package com.cercle.memberapi.business.service;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Member;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface AssociationService {

    List<AssociationDTO> getAllAssociations();

    AssociationDTO saveAssociation(Association association);

    AssociationDTO getAssociationById(String id);

    AssociationDTO updateAssociation(Association association);

    HttpStatus deleteAssociation(String id);

    List<Member> getAssociationMembers(String id);

    List<OrganizationDTO> getAssociationOrganizations(String id);
}
