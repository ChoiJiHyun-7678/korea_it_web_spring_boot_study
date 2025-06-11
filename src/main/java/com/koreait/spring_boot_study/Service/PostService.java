package com.koreait.spring_boot_study.Service;

import com.koreait.spring_boot_study.repositary.PostRepositary;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepositary postRepositary;

    public PostService(PostRepositary postRepositary){
        this.postRepositary = postRepositary;
    }
    public String getPost() {
        String  result = postRepositary.getPost();
        return "어떤 게시물의 우저 정보";
    }
}
