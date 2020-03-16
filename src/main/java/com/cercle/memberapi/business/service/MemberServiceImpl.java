package com.cercle.memberapi.business.service;

import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.exception.ResourceNotFoundException;
import com.cercle.memberapi.persistence.repository.MemberRepository;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@Service
public class MemberServiceImpl implements MemberService {

    private MemberRepository memberRepository;

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public Member getMemberById(UUID id) {
        return memberRepository.findById(id)
                .orElseThrow(ResourceNotFoundException::new);
    }

    @Override
    public Member save(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Set<Member> getMembers() {
        return new HashSet<>(memberRepository.findAll());
    }


}
