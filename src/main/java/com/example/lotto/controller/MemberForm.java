package com.example.lotto.controller;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;

@Getter
@Setter
public class MemberForm {

    @NotEmpty(message = "닉네임은 필수 입니다.")
    private String id;
    @NotEmpty(message = "비밀번호 양식에 맞게 작성해 주세요")
    private String pw;
    private String name;
    private int phone;
    private String email;
    private int birth;
    private String city;
    private String street;
    private String zipcode;
}
