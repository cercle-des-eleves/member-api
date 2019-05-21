package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.GroupMapper;
import com.cercle.memberapi.api.model.GroupDTO;
import com.cercle.memberapi.business.domain.Group;
import com.cercle.memberapi.business.service.GroupService;
import com.cercle.memberapi.persistence.repository.GroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.time.ZonedDateTime;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

class GroupServiceImplTest {


    private static final String NAME = "Group";
    private static final boolean ACTIVE = true;
    private static final ZonedDateTime CREATION_DATE = ZonedDateTime.now();
    @Mock
    private GroupRepository groupRepository;

    private String ID = UUID.randomUUID().toString();

    private GroupService service;


    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);
        GroupMapper mapper = new GroupMapper();

        this.service = new GroupServiceImpl(mapper, this.groupRepository);
    }

    @Test
    void getGroupWithID() {

        //given
        Group group = new Group(ID, NAME, ACTIVE, CREATION_DATE);

        when(groupRepository.findById(any(String.class))).thenReturn(Optional.of(group));


        //when
        GroupDTO result = service.getGroupWithID(ID.toString());

        //then
        assertEquals(ID, result.getId());
        assertEquals(NAME, result.getName());
        assertEquals(ACTIVE, result.getActive());
        assertEquals(CREATION_DATE, result.getCreationDate());



    }
}