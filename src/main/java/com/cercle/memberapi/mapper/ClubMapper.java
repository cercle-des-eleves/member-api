package com.cercle.memberapi.mapper;

import com.cercle.memberapi.api.v1.model.ClubDTO;
import com.cercle.memberapi.business.domain.Club;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ClubMapper {
    ClubDTO toClubDTO(Club club);

    Club toClub(ClubDTO clubDTO);
}
