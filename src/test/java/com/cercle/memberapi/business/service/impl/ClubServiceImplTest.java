package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.v1.ClubMapper;
import com.cercle.memberapi.api.v1.MemberMapper;
import com.cercle.memberapi.api.v1.model.ClubDTO;
import com.cercle.memberapi.business.domain.Club;
import com.cercle.memberapi.business.service.ClubService;
import com.cercle.memberapi.persistence.repository.ClubRepository;
import com.cercle.memberapi.persistence.repository.MemberRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import java.time.ZonedDateTime;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

class ClubServiceImplTest {
    @Mock
    private ClubRepository clubRepository;
    @Mock
    private MemberRepository memberRepository;

    private ClubMapper clubMapper = new ClubMapper();
    private MemberMapper memberMapper = new MemberMapper();

    private ClubService service;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.initMocks(this);

        service = new ClubServiceImpl(clubRepository, memberRepository, clubMapper, memberMapper);
    }

    @Test
    void shouldReturnClubList() {

        //given
        Page<Club> pages = new PageImpl<>(
                Arrays.asList(
                        new Club("id", "name", true, ZonedDateTime.now(), null, null),
                        new Club("id", "name", true, ZonedDateTime.now(), null, null),
                        new Club("id", "name", true, ZonedDateTime.now(), null, null),
                        new Club("id", "name", true, ZonedDateTime.now(), null, null)
                )
        );

        when(clubRepository.findAll(PageRequest.of(0,10, Sort.by("id")))).thenReturn(pages);
        //when
        List<ClubDTO> result = service.getAllClub(0, 10, "id");

        //then
        List<Club> clubs = pages.getContent();
        assertNotNull(result);
        assertEquals(clubs.size(), result.size());



    }
}