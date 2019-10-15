package com.cercle.memberapi.business.service.impl;

import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.service.MemberService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.List;

@Service
public class MemberServiceImpl implements MemberService {
    @Override
    public Member getStudentWithID(String id) {
        //TODO Pour montrer ce que ça retourne en Service mais à effectuer -> doit retourner un MemberDTO
        return new Member(id, "Girard-Blanc", "Bastien", "b.girardblanc@mines-ales.org",ZonedDateTime.now(),null);
    }

    @Override
    public List<Member> getAllMembers() {
        return null;
    }
}
