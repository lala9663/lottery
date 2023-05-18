package com.example.lottojpa.member.dto.requestDTO;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

@Getter
@Setter
public class SignupDTO {

    @NotEmpty(message = "아이디는 필수 입력값입니다.")
    @Pattern(regexp = "^(?=.*[a-z0-9])[a-z0-9]{3,16}$", message = "3자 이상 16자 이하, 영어 또는 숫자로 구성해야합니다.")
    private String memberId;

    @NotEmpty(message = "이메일은 필수 입력값입니다.")
    @Pattern(regexp = "^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+.[A-Za-z]{2,6}$", message = "이메일 형식에 맞지 않습니다.")
    private String memberEmail;

    @NotEmpty(message = "비밀번호는 필수 입력값입니다.")
    @Pattern(regexp = "^(?=.*[A-Za-z])(?=.*\\d)(?=.*[~!@#$%^&*()+|=])[A-Za-z\\d~!@#$%^&*()+|=]{8,16}$", message = "비밀번호는 8~16자 영문 대 소문자, 숫자, 특수문자를 사용하세요.")
    private String memberPassword;

    @NotEmpty(message = "휴대폰 번호를 작성해주세요")
    @Pattern(regexp = "^\\d{3}\\d{3,4}\\d{4}$", message = "-없이 작성해주세요")
    private String memberPhone;

//    @NotEmpty(message = "생일을 적어주세요")
//    @Pattern(regexp = "^([12]\\d{3}-(0[1-9]|1[0-2])-(0[1-9]|[12]\\d|3[01]))$", message = "YYYY-MM-DD 으로 작성해주세요")
    private LocalDate memberBirth;
    private boolean memberSmsAgree;
    private boolean memberEmailAgree;

}
