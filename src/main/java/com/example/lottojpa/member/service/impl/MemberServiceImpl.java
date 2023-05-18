package com.example.lottojpa.member.service.impl;

import com.example.lottojpa.member.dto.requestDTO.SignupDTO;
import com.example.lottojpa.member.dto.responseDTO.LoginDTO;
import com.example.lottojpa.member.entity.Member;
import com.example.lottojpa.member.exception.MemberException;
import com.example.lottojpa.member.repository.MemberRepository;
import com.example.lottojpa.member.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Objects;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {

    private final MemberRepository memberRepository;

    @Override
    @Transactional
    public void signup(SignupDTO signup) throws MemberException {
        String memberId = signup.getMemberId();

        // 아이디 중복 체크
        Optional<Member> findMember = memberRepository.findByMemberId(memberId);
        if (findMember.isPresent()) {
            throw new MemberException("이미 존재하는 아이디입니다.");
        }
        // 회원가입
        Member member = new Member();
        member.setMemberId(signup.getMemberId());
        member.setMemberEmail(signup.getMemberEmail());
        member.setMemberPassword(signup.getMemberPassword());
        member.setMemberPhone(signup.getMemberPhone());
        member.setMemberBirth(signup.getMemberBirth());
        member.setMemberEmailAgree(signup.isMemberEmailAgree());
        member.setMemberSmsAgree(signup.isMemberSmsAgree());
        memberRepository.save(member);
    }

    @Override
    public boolean login(LoginDTO login) throws MemberException {
        Optional<Member> memberOptional = memberRepository.findByMemberId(login.getMemberId());
        if (!memberOptional.isPresent()) {
            throw new MemberException("아이디가 존재하지 않습니다.");
        }
        Member member = memberOptional.get();
        if (!member.matchPassword(login.getMemberPassword())) {
            throw new MemberException("비밀번호가 틀렸습니다.");
        }
        return true;
    }
}
