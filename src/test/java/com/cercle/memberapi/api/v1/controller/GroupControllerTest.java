//package com.cercle.memberapi.api.v1.controller;
//
//import com.cercle.memberapi.api.v1.model.GroupDTO;
//import com.cercle.memberapi.business.service.impl.GroupServiceImpl;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//import org.springframework.test.web.servlet.MockMvc;
//import org.springframework.test.web.servlet.setup.MockMvcBuilders;
//
//import java.time.ZonedDateTime;
//import java.util.Arrays;
//import java.util.List;
//import java.util.UUID;
//
//import static org.mockito.Mockito.when;
//
//class GroupControllerTest {
//
//    private String ID = UUID.randomUUID().toString();
//    private String ID2 = UUID.randomUUID().toString();
//    private static final String NAME = "Group";
//    private static final boolean ACTIVE = true;
//    private static final ZonedDateTime CREATION_DATE = ZonedDateTime.now();
//
//    MockMvc mockMvc;
//
//    GroupController groupController;
//
//    @Mock
//    GroupServiceImpl groupService;
//
//
//    @BeforeEach
//    void setUp() {
//        mockMvc = MockMvcBuilders.standaloneSetup(GroupController.class).build();
//        MockitoAnnotations.initMocks(this);
//
//        groupController = new GroupController(groupService);
//    }
//
//    @Test
//    void getAllGroups() throws Exception {
//
//        //given
//        GroupDTO group1 = new GroupDTO(ID, NAME, ACTIVE, CREATION_DATE);
//        GroupDTO group2 = new GroupDTO(ID2, NAME, ACTIVE, CREATION_DATE);
//
//        List<GroupDTO> groups = Arrays.asList(group1, group2);
//
//        when(groupService.getAllGroups()).thenReturn(groups);
//
//        //when
//
//        //then
//        /*mockMvc.perform(get("/groups"))
//                .andExpect(status().isOk())
//                .andExpect(content().contentType(MediaType.APPLICATION_JSON));*/
//        groupController.getAllGroups();
//
//
//    }
//
//    @Test
//    void getGroup() {
//    }
//}