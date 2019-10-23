package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.api.v1.ClubMapper;
import com.cercle.memberapi.api.v1.MemberMapper;
import com.cercle.memberapi.api.v1.model.ClubDTO;
import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.business.domain.Club;
import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.exception.ResourceNotFoundException;
import com.cercle.memberapi.business.service.ClubService;
import com.cercle.memberapi.persistence.repository.ClubRepository;
import com.cercle.memberapi.persistence.repository.MemberRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;
    private MemberRepository memberRepository;
    private ClubMapper clubMapper;
    private MemberMapper memberMapper;

    public ClubServiceImpl(ClubRepository clubRepository,
                           MemberRepository memberRepository, ClubMapper clubMapper, MemberMapper memberMapper ) {
        this.clubRepository = clubRepository;
        this.memberRepository = memberRepository;
        this.clubMapper = clubMapper;
        this.memberMapper = memberMapper;
    }

    /**
     * Retrieve all clubs
     *
     * @return List<ClubDTO>
     */
    @Override
    public List<ClubDTO> getAllClub(Integer pageNo, Integer pageSize, String sortBy) {
        Pageable paging = PageRequest.of(pageNo, pageSize, Sort.by(sortBy));

        Page<Club> pagedResult = clubRepository.findAll(paging);

        if(pagedResult.hasContent()) {
            return pagedResult.getContent().stream().map(clubMapper::toClubDTO).collect(Collectors.toList());
        } else {
            return new ArrayList<>();
        }
    }

    @Override
    public ClubDTO saveClub(Club club) {
        Club result = clubRepository.save(club);

        return clubMapper.toClubDTO(result);
    }

    @Override
    public ClubDTO getClubById(String id) {
        return clubRepository.findById(id)
                .map(club -> clubMapper.toClubDTO(club))
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public ClubDTO updateClub(Club club) {
        Club result = clubRepository.save(club);

        return clubMapper.toClubDTO(result);
    }

    @Override
    public void deleteClub(String id) {
        try {
            clubRepository.deleteById(id);
        } catch (EntityNotFoundException e) {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public List<MemberDTO> getClubMembers(String id) {
        Optional<Club> association = clubRepository.findById(id);
        if (association.isPresent()) {
            List<Member> members = association.get().getMembers();
            return members.stream().map(memberMapper::toMemberDTO).collect(Collectors.toList());
        } else {
            throw new ResourceNotFoundException();
        }

    }

    @Override
    public ClubDTO addClubMember(String clubId, String memberId) {
        Optional<Club> club = clubRepository.findById(clubId);
        Optional<Member> member = memberRepository.findById(memberId);

        if (club.isPresent() && member.isPresent()) {
            Club temp_club = club.get();
            temp_club.getMembers().add(member.get());
            temp_club = clubRepository.save(temp_club);
            return clubMapper.toClubDTO(temp_club);
        } else {
            throw new ResourceNotFoundException();
        }
    }

    @Override
    public ClubDTO removeClubMember(String clubId, String memberId) {
        Optional<Club> club = clubRepository.findById(clubId);
        Optional<Member> member = memberRepository.findById(memberId);

        if (club.isPresent() && member.isPresent()) {
            Club temp_club = club.get();
            temp_club.getMembers().remove(member.get());
            temp_club = clubRepository.save(temp_club);
            return clubMapper.toClubDTO(temp_club);
        } else {
            throw new ResourceNotFoundException();
        }
    }
}
