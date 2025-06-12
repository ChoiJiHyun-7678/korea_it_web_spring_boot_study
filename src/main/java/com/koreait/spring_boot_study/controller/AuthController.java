package com.koreait.spring_boot_study.controller;

import com.koreait.spring_boot_study.dto.SignupReqDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/auth")
public class AuthController {
    // 클라이언트가 UPL 퀴리스트링으로 넘긴 값을 메소드 파라미터로 받는다.


    @GetMapping("/get")
    public String getUser(@RequestParam String userId) {
        System.out.println("RequestParm으로 들어올 값 : " + userId);
        return "RequestParm으로 들어올 값 : " + userId;
    }

    @GetMapping("/get/name")
    public String gerUsername(@RequestParam(value = "홍길동") String username, @RequestParam(required = false) Integer age) {
        System.out.println(username + age);
        return username + age;
    }
    // 안에서 사용하는 변수명과 쿼리스트링으ㅏ 키값이 다른경우 괄호안에 표기해주면 됨
    // 그리고 기본값설정이 가능함
    // 그리고 다른타입도 가능하며 여려개의 RequstParm도 받을수있다.
    // int는 null을 허용하지 않기때문에 값이 없음 상태
    // 그래서 = false를 했지만 에러가 뜸 -> intger로 해야 null로 받을수있다.
    // 만약 필수값이 거짓이고 기본값이 설정되어있다면 필수값 설정이 무의미하다

    @GetMapping("/get/names")
    public String getUsernames(@RequestParam List<String> names){
        return names.toString();
    }

    // 주의사항
    // 파라미터가 없으면 500에러
    // 또는 타입이 안맞을때
    // 이름입 불일치할때

    // 요청주소 = search / name, email
    // name은 필수가 아니록, 이메일은 기본값으로 no email
    // 요청 => /auth/search?name=lee
    // 반환 => "검색조건 - 이름 :
    @GetMapping("/get/search")
    public String getNameEmail(@RequestParam(required = false) String name, @RequestParam (defaultValue = "no-email") String email){
        System.out.println("검색조건 - 이름 : " + name + "이메일 : " + email);
        return "검색조건 - 이름 : " + name + "   , 이메일 : " + email;
    }

    //Requstbody
    //Http ㅛ엋ㅇ의 바다에 들어있는 Json 데이터를 자바객체로 변환해서 주입해주는 어노테이션
    // 백엔드 서버는 그 Json를 DTO로 자동실행

    // DTI (Data Transfer Object)
    // 데이터를 전달하기 위한 객체
    // 클라이언트간에 데이터를 주고받을때 사용하는 중간 객체

    @PostMapping("/signup")
    public String signup(@RequestBody SignupReqDto signupReqDto) {
        System.out.println(signupReqDto);
        return signupReqDto.getUsername() + "님 회원가입이 완료되었습니다!!";
    }

    // 포스트요청 signin이라는 로그인을 생성
    // SigninReqDto -> email, password
    // 반환 -> "로그인 완료 : " + SigninReqDto.getEmail() + "님 반갑습니다."
    @PostMapping("/signin")
    public String signin(@RequestBody SignupReqDto signinReqDto) {
        System.out.println(signinReqDto);
        return "로그인 완료 : " + signinReqDto.getEmail() + "님 환영합니다!!!";
    }

}
