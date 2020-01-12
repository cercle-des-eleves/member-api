package com.cercle.memberapi.api.v1.model;

import com.cercle.memberapi.business.domain.Board;
import com.cercle.memberapi.business.domain.Club;
import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.domain.Organization;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.ZonedDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AssociationDetailedDTO {
    private String id;
    private String name;
    private Boolean active;
    private ZonedDateTime creationDate;
    private Member president;
    private List<MemberDTO> members;
    private List<AssociationDTO> associations;
    private List<BoardDTO> boards;
    private List<ClubDTO> clubs;
    private String siret;
}
