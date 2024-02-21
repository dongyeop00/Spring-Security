package com.gdy.springsecurity.Controller;


import com.gdy.springsecurity.Dto.MemberDTO;
import com.gdy.springsecurity.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class MemberController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinForm(){
        return "join";
    }

    @PostMapping("/joinProc")
    public String join(MemberDTO memberDTO){
        System.out.println(memberDTO);
        memberService.join(memberDTO);
        return "index";
    }
}
