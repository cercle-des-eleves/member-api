package com.cercle.memberapi.business.service;

import com.cercle.memberapi.api.v1.model.ClubDTO;
import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.business.domain.Club;

import java.util.List;

public interface ClubService {

    List<ClubDTO> getAllClub(Integer pageNo, Integer pageSize, String sortBy);

    ClubDTO saveClub(Club club);

    ClubDTO getClubById(String id);

    ClubDTO updateClub(Club club);

    void deleteClub(String id);

    List<MemberDTO> getClubMembers(String id);

    ClubDTO addClubMember(String clubId, String memberId);

    ClubDTO removeClubMember(String clubId, String memberId);
}
