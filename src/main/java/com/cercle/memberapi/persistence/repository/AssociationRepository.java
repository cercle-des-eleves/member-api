package com.cercle.memberapi.persistence.repository;

import com.cercle.memberapi.business.domain.Association;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AssociationRepository extends JpaRepository<Association, String> {

}
