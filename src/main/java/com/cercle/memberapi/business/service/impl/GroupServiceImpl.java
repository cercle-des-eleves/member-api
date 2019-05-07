package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.model.GroupDTO;
import com.cercle.memberapi.business.service.GroupService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;

@Service
public class GroupServiceImpl implements GroupService {
    @Override
    public GroupDTO getGroupWithID(String id) {
        return new GroupDTO(id,"BDE",true, ZonedDateTime.now());
    }
}
