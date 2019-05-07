package com.cercle.memberapi.api.controller;


import com.cercle.memberapi.api.model.GroupDTO;
import com.cercle.memberapi.business.service.GroupService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/groups")
public class GroupController {

    private GroupService groupService;

    public GroupController(GroupService groupService) {
        this.groupService = groupService;
    }

    @GetMapping("{groupId}")
    public ResponseEntity<GroupDTO> getGroup(@PathVariable String groupId) {

        return new ResponseEntity<>(groupService.getGroupWithID(groupId), HttpStatus.OK);
    }
}
