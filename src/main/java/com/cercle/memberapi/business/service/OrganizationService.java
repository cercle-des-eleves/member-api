package com.cercle.memberapi.business.service;

import com.cercle.memberapi.api.v1.model.GroupDTO;

import java.util.List;

public interface OrganizationService {

   GroupDTO getOrganizationWithID(String id);

   List<GroupDTO> getAllOrganizations();
}
