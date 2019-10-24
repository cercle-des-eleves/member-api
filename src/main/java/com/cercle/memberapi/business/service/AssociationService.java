package com.cercle.memberapi.business.service;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Member;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface AssociationService {

    List<AssociationDTO> getAllAssociations(Integer pageNo, Integer pageSize, String sortBy);

    AssociationDTO saveAssociation(Association association);

    AssociationDTO getAssociationById(String id);

    AssociationDTO updateAssociation(Association association);

    void deleteAssociation(String id);

    List<MemberDTO> getAssociationMembers(String id);

    List<OrganizationDTO> getAssociationOrganizations(String id);

    AssociationDTO addAssociationOrganization(String associationId, String organizationId);

    AssociationDTO removeAssociationOrganization(String associationId, String organizationId);

    AssociationDTO addAssociationMember(String associationId, String memberId);

    AssociationDTO removeAssociationMember(String associationId, String memberId);
}
