package com.cercle.memberapi.business.service;

import com.cercle.memberapi.business.domain.Club;
import com.cercle.memberapi.business.exception.ResourceNotFoundException;
import com.cercle.memberapi.persistence.repository.ClubRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class ClubServiceImpl implements ClubService {

    private ClubRepository clubRepository;

    public ClubServiceImpl(ClubRepository clubRepository) {
        this.clubRepository = clubRepository;
    }

    @Override
    public Club getClubById(UUID id) {
        return clubRepository.findById(id).orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Club save(Club club) {
        return clubRepository.save(club);
    }

    @Override
    public Set<Club> getClubs() {
        return new HashSet<>(clubRepository.findAll());
    }
}
