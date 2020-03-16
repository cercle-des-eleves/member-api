package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.business.domain.Club;
import com.cercle.memberapi.business.service.ClubService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/clubs")
public class ClubController {

    private ClubService clubService;

    public ClubController(ClubService clubService) {
        this.clubService = clubService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Club getClubById(@PathVariable String id) {
        return clubService.getClubById(UUID.fromString(id));
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Club createClub(@RequestBody Club club) {
        return clubService.save(club);
    }
}
