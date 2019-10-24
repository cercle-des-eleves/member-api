package com.cercle.memberapi.api.v1;

import com.cercle.memberapi.api.v1.model.AssociationDTO;
import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.api.v1.model.MemberDetailedDTO;
import com.cercle.memberapi.api.v1.model.OrganizationDTO;
import com.cercle.memberapi.business.domain.Association;
import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.domain.Organization;
import org.springframework.stereotype.Component;

import java.util.stream.Collectors;

@Component
public class MemberMapper {
    private OrganizationMapper organizationMapper;

    public MemberMapper(OrganizationMapper organizationMapper) {
        this.organizationMapper = organizationMapper;
    }

    public MemberDetailedDTO toMemberDetailedDTO(Member member) {
        return new MemberDetailedDTO(
                member.getId(),
                member.getLastName(),
                member.getFirstName(),
                member.getMail(),
                member.getCreationDate(),
                member.getPromotion(),
                member.getOrganizations().stream().map(organizationMapper::toOrganizationDTO).collect(Collectors.toList())
        );
    }

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

    public Member toMember(MemberDetailedDTO memberDTO) {
        return new Member(
                memberDTO.getId(),
                memberDTO.getLastName(),
                memberDTO.getFirstName(),
                memberDTO.getMail(),
                memberDTO.getCreationDate(),
                memberDTO.getPromotion(),
                memberDTO.getOrganizations().stream().map(organizationMapper::toOrganization).collect(Collectors.toList())
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
