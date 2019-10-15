package com.cercle.memberapi.business.service;

import com.cercle.memberapi.api.v1.model.OrganizationDTO;

import java.util.List;

public interface OrganizationService {

   OrganizationDTO getOrganizationWithID(String id);

   List<OrganizationDTO> getAllOrganizations();
}
