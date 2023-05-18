package com.example.lottojpa.member.service;

import com.example.lottojpa.member.dto.requestDTO.SignupDTO;
import com.example.lottojpa.member.dto.responseDTO.LoginDTO;
import com.example.lottojpa.member.exception.MemberException;

public interface MemberService {
    void signup(SignupDTO signup) throws MemberException;
    boolean login(LoginDTO login) throws MemberException;

}
