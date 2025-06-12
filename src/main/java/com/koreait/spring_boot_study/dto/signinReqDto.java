package com.koreait.spring_boot_study.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
public class signinReqDto {

    @Data
    @AllArgsConstructor
    public class SignupReqDto {
        private String username;
        private String password;
        private String email;
    }

}
