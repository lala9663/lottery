package com.example.lottojpa.member.entity;

import com.example.lottojpa.global.entity.CreateDate;
import com.example.lottojpa.global.entity.ModifyDate;
import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Entity(name = "members")
@Getter
@Setter
@NoArgsConstructor
public class Member extends ModifyDate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "m_id")
    private String mId;

    @Column(name = "member_id", nullable = false)
    private String memberId;

    @Column(name = "member_email", nullable = false)
    private String memberEmail;

    @Column(name = "member_pw", nullable = false)
    private String memberPassword;

    @Column(name = "member_name", nullable = false)
    private String memberName;

    @Column(name = "member_phone",nullable = false)
    private String memberPhone;

    @Column(name = "member_birth", nullable = false)
    private LocalDate memberBirth;

    @Column(name = "member_deleted", nullable = false)
    private boolean memberDeleted = false;

    @Column(name = "member_sms_agree", nullable = false)
    private boolean memberSmsAgree;

    @Column(name = "member_email_agree", nullable = false)
    private boolean memberEmailAgree;


    public boolean matchPassword(String memberPassword) {
        return this.memberPassword.equals(memberPassword);
    }

}
