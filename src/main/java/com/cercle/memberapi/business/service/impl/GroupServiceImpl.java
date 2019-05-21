package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.GroupMapper;
import com.cercle.memberapi.api.model.GroupDTO;
import com.cercle.memberapi.business.domain.Group;
import com.cercle.memberapi.business.service.GroupService;
import com.cercle.memberapi.persistence.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

@Service
public class GroupServiceImpl implements GroupService {

    private GroupMapper groupMapper;
    private GroupRepository groupRepository;

    public GroupServiceImpl(GroupMapper groupMapper, GroupRepository groupRepository) {
        this.groupMapper = groupMapper;
        this.groupRepository = groupRepository;
    }

    @Override
    public GroupDTO getGroupWithID(String id) {

        Optional<Group> result = groupRepository.findById(UUID.fromString(id));

        return result.map(group -> groupMapper.toGroupDTO(group)).orElseThrow(() -> new RuntimeException("Group Not Found"));
    }
}
