package com.cercle.memberapi.persistence.repository;

import com.cercle.memberapi.business.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.UUID;


@Service
public interface ClubRepository extends JpaRepository<Club, UUID> {
}
