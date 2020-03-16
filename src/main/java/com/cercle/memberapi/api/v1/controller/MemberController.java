package com.cercle.memberapi.api.v1.controller;

import com.cercle.memberapi.business.domain.Member;
import com.cercle.memberapi.business.service.MemberService;
import com.sun.jndi.toolkit.url.Uri;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriBuilder;

import javax.servlet.http.HttpServletRequest;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.util.UUID;

@RestController
@RequestMapping("/members")
public class MemberController {

    private MemberService memberService;

    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Member getMemberById(@PathVariable String id) {

        return memberService.getMemberById(UUID.fromString(id));
    }

    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public Member saveMember(@RequestBody Member member, HttpServletRequest request) {
        return memberService.save(member);
    }
}
