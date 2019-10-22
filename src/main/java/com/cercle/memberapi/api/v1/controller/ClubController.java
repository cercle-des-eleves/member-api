package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.api.v1.model.ClubDTO;
import com.cercle.memberapi.business.service.ClubService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public ResponseEntity<List<ClubDTO>> getAllClub(Integer pageNo, Integer pageSize, String sortBy) {
        List<ClubDTO> club = clubService.getAllClub(pageNo,pageSize, sortBy);
        return new ResponseEntity<>(club, HttpStatus.OK);
    }
}
