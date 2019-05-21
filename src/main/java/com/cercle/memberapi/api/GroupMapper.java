package com.cercle.memberapi.api;

import com.cercle.memberapi.api.model.GroupDTO;
import com.cercle.memberapi.business.domain.Group;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class GroupMapper {

    public GroupDTO toGroupDTO(Group group) {
        return new GroupDTO(
                group.getId().toString(),
                group.getName(),
                group.getActive(),
                group.getCreationDate());
    }

    public Group toGroup(GroupDTO groupDTO) {
        return new Group(
                UUID.fromString(groupDTO.getId()),
                groupDTO.getName(),
                groupDTO.getActive(),
                groupDTO.getCreationDate());
    }
}
