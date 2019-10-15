package com.cercle.memberapi.business.service;

import com.cercle.memberapi.business.domain.Member;

import java.util.List;

public interface MemberService {
    Member getStudentWithID(String id);

    List<Member> getAllMembers();
}
