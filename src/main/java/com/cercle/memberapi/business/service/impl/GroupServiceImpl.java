package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.v1.GroupMapper;
import com.cercle.memberapi.api.v1.model.GroupDTO;
import com.cercle.memberapi.business.domain.Group;
import com.cercle.memberapi.business.service.GroupService;
import com.cercle.memberapi.persistence.repository.GroupRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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

        Optional<Group> result = groupRepository.findById(id);
        
        return result.map(group -> groupMapper.toGroupDTO(group)).orElseThrow(() -> new RuntimeException("Group Not Found"));
    }

    @Override
    public List<GroupDTO> getAllGroups() {
        List<Group> result = groupRepository.findAll();

        return result.stream()
                .map(groupMapper::toGroupDTO)
                .collect(Collectors.toList());
    }
}
