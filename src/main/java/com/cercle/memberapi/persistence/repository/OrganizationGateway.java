package com.cercle.memberapi.persistence.repository;

import com.cercle.memberapi.business.domain.Organization;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OrganizationGateway extends JpaRepository<Organization, String> {

    @Override
    Optional<Organization> findById(String id);

    @Override
    List<Organization> findAll();
}
