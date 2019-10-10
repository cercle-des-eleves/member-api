//package com.cercle.memberapi.business.service.impl;
//
//import com.cercle.memberapi.api.v1.GroupMapper;
//import com.cercle.memberapi.api.v1.model.GroupDTO;
//import com.cercle.memberapi.business.domain.Organization;
//import com.cercle.memberapi.business.service.OrganizationService;
//import com.cercle.memberapi.persistence.repository.GroupRepository;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Test;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.time.ZonedDateTime;
//import java.util.*;
//
//import static org.junit.jupiter.api.Assertions.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.when;
//
//class GroupServiceImplTest {
//
//
//    private String ID = UUID.randomUUID().toString();
//    private String ID2 = UUID.randomUUID().toString();
//    private static final String NAME = "Organization";
//    private static final boolean ACTIVE = true;
//    private static final ZonedDateTime CREATION_DATE = ZonedDateTime.now();
//
//    @Mock
//    private GroupRepository groupRepository;
//
//
//    private OrganizationService service;
//
//
//    @BeforeEach
//    void setUp() {
//        MockitoAnnotations.initMocks(this);
//        GroupMapper mapper = new GroupMapper();
//
//        this.service = new OrganizationServiceImpl(mapper, this.groupRepository);
//    }
//
//    @Test
//    void getGroupWithIDTest() {
//
//        //given
//        Organization group = new Organization(ID, NAME, ACTIVE, CREATION_DATE);
//
//        when(groupRepository.findById(any(String.class))).thenReturn(Optional.of(group));
//
//
//        //when
//        GroupDTO result = service.getOrganizationWithID(ID.toString());
//
//        //then
//        assertEquals(ID, result.getId());
//        assertEquals(NAME, result.getName());
//        assertEquals(ACTIVE, result.getActive());
//        assertEquals(CREATION_DATE, result.getCreationDate());
//
//
//
//    }
//
//    @Test
//    void getGroupWithIdNotFoundExceptionTest(){
//
//        assertThrows(RuntimeException.class,()->{
//            //given
//            Organization group = new Organization(ID, NAME, ACTIVE, CREATION_DATE);
//
//            when(groupRepository.findById(any(String.class))).thenReturn(Optional.empty());
//
//
//            //when
//            GroupDTO result = service.getOrganizationWithID(ID.toString());
//        });
//
//    }
//
//    @Test
//    void getAllGroupsTest(){
//
//        //given
//        Organization group1 = new Organization(ID, NAME, ACTIVE, CREATION_DATE);
//        Organization group2 = new Organization(ID2, NAME, ACTIVE, CREATION_DATE);
//
//        List<Organization> organizations = Arrays.asList(group1, group2);
//
//        when(groupRepository.findAll()).thenReturn(organizations);
//
//        //when
//        List<GroupDTO> result = service.getAllOrganizations();
//
//        //then
//
//        assertEquals(2,result.size());
//
//    }
//}