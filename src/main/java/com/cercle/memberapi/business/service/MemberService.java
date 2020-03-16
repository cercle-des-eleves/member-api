package com.cercle.memberapi.business.service;

import com.cercle.memberapi.business.domain.Member;

import java.util.Set;
import java.util.UUID;

public interface MemberService {
    Member getMemberById(UUID id);

    Member save(Member member);

    Set<Member> getMembers();

}
