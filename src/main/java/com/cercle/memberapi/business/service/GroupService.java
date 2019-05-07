package com.cercle.memberapi.business.service;

import com.cercle.memberapi.api.v1.model.GroupDTO;

public interface GroupService {
   GroupDTO getGroupWithID(String id);
}
