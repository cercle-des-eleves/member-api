package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.api.v1.model.ClubDTO;
import com.cercle.memberapi.api.v1.model.MemberDTO;
import com.cercle.memberapi.business.domain.Club;
import com.cercle.memberapi.business.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@AllArgsConstructor
@RequestMapping(path = "/clubs")
public class ClubController {

    private ClubService clubService;

    /**
     * Retrieve all clubs
     *
     * @return List<Clubs>
     */
    @GetMapping
    public ResponseEntity<List<ClubDTO>> getAllClub(@RequestParam(defaultValue = "0") Integer pageNo, @RequestParam(defaultValue = "10") Integer pageSize, @RequestParam(defaultValue = "id") String sortBy) {
        List<ClubDTO> club = clubService.getAllClub(pageNo,pageSize, sortBy);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    /**
     * Create a new club
     *
     * @param club
     * @return
     */
    @PostMapping
    public ResponseEntity<ClubDTO> saveClub(@RequestBody Club club) {
        ClubDTO result = clubService.saveClub(club);
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    /**
     * Get specific club
     *
     * @param clubId
     * @return
     */
    @GetMapping("{clubId}")
    public ResponseEntity<ClubDTO> getClubById(@PathVariable String clubId) {
        return new ResponseEntity<>(clubService.getClubById(clubId), HttpStatus.OK);
    }

    /**
     * Update specific club
     *
     * @param clubId
     * @param club
     * @return
     */
    @PutMapping("{clubId}")
    public ResponseEntity<ClubDTO> updateClubById(@PathVariable String clubId, @RequestBody Club club) {
        club.setId(clubId);
        ClubDTO club_temp = clubService.updateClub(club);
        return new ResponseEntity<>(club_temp, HttpStatus.OK);
    }

    /**
     * Delete specific club
     *
     * @param clubId
     * @return
     */
    @DeleteMapping("{clubId}")
    public ResponseEntity<ClubDTO> deleteClubById(@PathVariable String clubId) {
        clubService.deleteClub(clubId);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * Retrieve members of club
     *
     * @param clubId
     * @return
     */
    @GetMapping("{clubId}/members")
    public ResponseEntity<List<MemberDTO>> getMembersByClub(@PathVariable String clubId) {
        return new ResponseEntity<>(clubService.getClubMembers(clubId), HttpStatus.OK);
    }

    /**
     * Add a member to club
     *
     * @param clubId
     * @param memberId
     * @return
     */
    @PostMapping("{clubId}/members/{memberId}")
    public ResponseEntity<ClubDTO> addMemberToClub(@PathVariable String clubId, @PathVariable String memberId) {
        ClubDTO club = clubService.addClubMember(clubId, memberId);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }

    /**
     * Remove a member from club
     *
     * @param clubId
     * @param memberId
     * @return
     */
    @DeleteMapping("{clubId}/members/{memberId}")
    public ResponseEntity<ClubDTO> removeMemberFromClub(@PathVariable String clubId, @PathVariable String memberId) {
        ClubDTO club = clubService.removeClubMember(clubId, memberId);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }
}
