package com.cercle.memberapi.business.service;

import com.cercle.memberapi.api.v1.model.GroupDTO;

import java.util.List;

public interface GroupService {

   GroupDTO getGroupWithID(String id);

   List<GroupDTO> getAllGroups();
}
