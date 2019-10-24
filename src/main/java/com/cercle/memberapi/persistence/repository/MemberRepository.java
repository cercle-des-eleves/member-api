package com.cercle.memberapi.persistence.repository;

import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.domain.Organization;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MemberRepository extends JpaRepository<Member, String> {

    @Query("SELECT m from Member m join m.organizations organization where organization.id = ?1")
    Page<Member> getAllMembersByOrganization(String organizationId, Pageable pageable);

}
