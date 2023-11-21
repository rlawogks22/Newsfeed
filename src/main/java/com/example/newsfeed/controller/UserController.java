package com.example.newsfeed.controller;


import com.example.newsfeed.dto.CommonResponseDto;
import com.example.newsfeed.dto.LoginRequestDto;
import com.example.newsfeed.dto.SignupRequestDto;
import com.example.newsfeed.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<CommonResponseDto> signup(@Validated @RequestBody SignupRequestDto signupRequestDto,
                                                    BindingResult bindingResult) {
        // 정규표현식 유효성을 판단하기 위해
        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        if (fieldErrors.size() > 0) {
            for (FieldError fieldError : bindingResult.getFieldErrors()) {
                log.error(fieldError.getField() + " 필드 : " + fieldError.getDefaultMessage());
                return ResponseEntity.badRequest().body(
                        new CommonResponseDto(fieldError.getDefaultMessage(), HttpStatus.BAD_REQUEST.value()));
            }
        }
        userService.signup((signupRequestDto));
        return ResponseEntity.status(HttpStatus.OK.value()).body((
                new CommonResponseDto("성공적으로 회원가입에 성공했습니다.", HttpStatus.OK.value())));
    }
}
