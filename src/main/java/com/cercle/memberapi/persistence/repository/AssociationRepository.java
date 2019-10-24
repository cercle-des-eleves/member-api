package com.cercle.memberapi.persistence.repository;

import com.cercle.memberapi.business.domain.Association;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AssociationRepository extends JpaRepository<Association, String> {

}
