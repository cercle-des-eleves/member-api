package com.cercle.memberapi.api.v1;

import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.business.domain.Member;
import org.springframework.stereotype.Component;

@Component
public class MemberMapper {

    public MemberDTO toMemberDTO(Member member) {
        return new MemberDTO(
                member.getId(),
                member.getLastName(),
                member.getFirstName(),
                member.getMail(),
                member.getCreationDate(),
                member.getPromotion()
        );
    }

    public Member toMember(MemberDTO memberDTO) {
        return new Member(
                memberDTO.getId(),
                memberDTO.getLastName(),
                memberDTO.getFirstName(),
                memberDTO.getMail(),
                memberDTO.getCreationDate(),
                memberDTO.getPromotion()
        );
    }
}
