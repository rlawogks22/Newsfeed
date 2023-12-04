package com.example.newsfeed.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

@Transactional
@DisplayName("유저 서비스 테스트")
class UserServiceTest {

    @Autowired
    UserService userService;

    @DisplayName("회원가입 성공시")
    @Test
    void signup_1() {

    }

    @Test
    void login() {
    }

    @Test
    void viewMypage() {
    }

    @Test
    void checkPwd() {
    }

    @Test
    void updateUserService() {
    }
}