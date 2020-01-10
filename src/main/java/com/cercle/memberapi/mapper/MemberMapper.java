package com.cercle.memberapi.mapper;

import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.api.v1.model.MemberDetailedDTO;
import com.cercle.memberapi.business.domain.Member;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")

public interface MemberMapper {
    MemberDetailedDTO toMemberDetailedDTO(Member member);

    MemberDTO toMemberDTO(Member member);

    Member toMember(MemberDetailedDTO memberDTO);

    Member toMember(MemberDTO memberDTO);
}
