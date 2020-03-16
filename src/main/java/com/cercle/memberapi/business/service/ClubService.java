package com.cercle.memberapi.business.service;

import com.cercle.memberapi.business.domain.Club;

import java.util.Set;
import java.util.UUID;

public interface ClubService {
    Club getClubById(UUID id);

    Club save(Club club);

    Set<Club> getClubs();

}
