package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

// 어노테이션을 통해서 Spring이 맨처음 작동될때 Spring Container라는 통이 생기는데 거기에 객체를 미리 생성해서 넣어두고 Spring이 관리함
@Controller
public class MemberController {
    private final MemberService memberService;

    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
