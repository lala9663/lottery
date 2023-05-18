package com.example.lottojpa.member.controller;

import com.example.lottojpa.member.dto.requestDTO.SignupDTO;
import com.example.lottojpa.member.dto.responseDTO.LoginDTO;
import com.example.lottojpa.member.exception.MemberException;
import com.example.lottojpa.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MemberController {
    private final MemberService memberService;
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @PostMapping("/signup")
    public ResponseEntity<?> signup(@Validated @RequestBody SignupDTO signup) {
        try {
            memberService.signup(signup);
            return ResponseEntity.ok().build();
        } catch (MemberException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@Validated @RequestBody LoginDTO login) {
        try {
            memberService.login(login);
            return ResponseEntity.ok().build();
        } catch (MemberException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
