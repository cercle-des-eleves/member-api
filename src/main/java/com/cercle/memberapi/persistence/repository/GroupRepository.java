package com.cercle.memberapi.persistence.repository;

import com.cercle.memberapi.business.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {

    @Override
    Optional<Group> findById(String id);
}
