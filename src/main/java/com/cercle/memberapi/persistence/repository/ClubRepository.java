package com.cercle.memberapi.persistence.repository;

import com.cercle.memberapi.business.domain.Club;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClubRepository  extends JpaRepository<Club, String> {
}
