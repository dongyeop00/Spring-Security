package com.gdy.springsecurity.Controller;

import com.gdy.springsecurity.Dto.MemberDTO;
import com.gdy.springsecurity.Service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.lang.reflect.Member;

@Controller
@RequiredArgsConstructor
public class JoinController {

    private final MemberService memberService;

    @GetMapping("/join")
    public String joinP(){
        return "join";
    }

    @PostMapping("/joinProc")
    public String joinProcess(MemberDTO memberDTO){
        System.out.println(memberDTO.getUsername());
        memberService.join(memberDTO);
        return "redirect:/join";
    }
}
