package com.koreait.spring_boot_study.repositary;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepositary {
    public String getPost() {
        System.out.println("레포지토리까지 요청이 왔다감");
        return "레포지토리에서 보낸 어떠한 데이터";
    }
}