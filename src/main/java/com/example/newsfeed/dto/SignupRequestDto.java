package com.example.newsfeed.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignupRequestDto {
    @NotBlank(message = "아이디는 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-z0-9]{4,10}$", message = "사용자 아이디는 소문자와 숫자로만 이루어져있는 4~10글자로 입력해주세요.")
    private String username;
    @NotBlank(message = "비밀번호는 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{8,15}$", message = "비밀번호는 소문자, 대문자, 숫자로만 이루어진 8~15글자로 입력해주세요.")
    private String pwd;
    @NotBlank(message = "이메일은 필수 입력 값입니다.")
    @Email(message = "email 형식과 맞지 않습니다.")
    private String email;
    @NotBlank(message = "닉네임은 필수 입력 값입니다.")
    @Pattern(regexp = "^[a-zA-Z0-9]{2,6}$", message = "닉네임은 소문자, 대문자, 숫자로만 이루어진 2~6글자로 입력해주세요.")
    private String nickname;

    @Pattern(regexp = "^[a-zA-Z0-9ㄱ-ㅎ가-힣]{1,15}$", message = "한줄 소개는 15자 이하까지 입력 가능합니다.")
    private String profile;
}