package com.koreait.spring_boot_study.repositary;

import org.springframework.stereotype.Repository;

@Repository
public class PostRepositary {
    public String getPost(){
        System.out.println("레퍼지토리 요청이 왔다감");
        return "qww";
    }

}
