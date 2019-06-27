package com.cercle.memberapi.persistence.repository;

import com.cercle.memberapi.business.domain.Group;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GroupRepository extends JpaRepository<Group, String> {

    @Override
    Optional<Group> findById(String id);

    @Override
    List<Group> findAll();
}
