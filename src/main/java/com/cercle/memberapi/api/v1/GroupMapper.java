package com.cercle.memberapi.api.v1;

import com.cercle.memberapi.api.v1.model.GroupDTO;
import com.cercle.memberapi.business.domain.Group;
import org.springframework.stereotype.Component;


@Component
public class GroupMapper {

    public GroupDTO toGroupDTO(Group group) {
        return new GroupDTO(
                group.getId(),
                group.getName(),
                group.getActive(),
                group.getCreationDate(),
                group.getPresident(),
                group.getMembers());
    }

    public Group toGroup(GroupDTO groupDTO) {
        return new Group(
                groupDTO.getId(),
                groupDTO.getName(),
                groupDTO.getActive(),
                groupDTO.getCreationDate(),
                groupDTO.getPresident(),
                groupDTO.getMembers());
    }
}
