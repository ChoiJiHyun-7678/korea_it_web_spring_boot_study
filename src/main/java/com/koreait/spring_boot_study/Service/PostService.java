package com.koreait.spring_boot_study.Service;

import com.koreait.spring_boot_study.repositary.PostRepositary;
import org.springframework.stereotype.Service;

@Service
public class PostService {
    private final PostRepositary postRepository;

    public PostService(PostRepositary postRepository) {
        this.postRepository = postRepository;
    }
    public String getPost() {
        String result = postRepository.getPost();
        return result;
    }
}