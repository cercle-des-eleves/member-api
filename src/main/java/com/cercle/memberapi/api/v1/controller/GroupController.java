package com.cercle.memberapi.api.v1.controller;


import com.cercle.memberapi.api.v1.model.GroupDTO;
import com.cercle.memberapi.api.v1.model.GroupsDTO;
import com.cercle.memberapi.business.service.GroupService;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@NoArgsConstructor
@Controller
@RequestMapping(path = "/groups")
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping
    public ResponseEntity<GroupsDTO> getAllGroups() {

        GroupsDTO groups = new GroupsDTO(groupService.getAllGroups());
        return new ResponseEntity<>(groups, HttpStatus.OK);
    }

    @GetMapping("{groupId}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable String groupId) {


        return new ResponseEntity<>(groupService.getGroupWithID(groupId), HttpStatus.OK);
    }
}
