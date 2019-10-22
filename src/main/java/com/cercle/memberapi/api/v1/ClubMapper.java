package com.cercle.memberapi.api.v1;

import com.cercle.memberapi.api.v1.model.ClubDTO;
import com.cercle.memberapi.business.domain.Club;
import org.springframework.stereotype.Component;

@Component
public class ClubMapper {

    public ClubDTO toClubDTO(Club club) {
        return new ClubDTO(
                club.getId(),
                club.getName(),
                club.getActive(),
                club.getCreationDate(),
                club.getPresident(),
                club.getMembers()
        );
    }

    public Club toClub(ClubDTO clubDTO) {
        return new Club(
                clubDTO.getId(),
                clubDTO.getName(),
                clubDTO.getActive(),
                clubDTO.getCreationDate(),
                clubDTO.getPresident(),
                clubDTO.getMembers()
        );
    }
}
