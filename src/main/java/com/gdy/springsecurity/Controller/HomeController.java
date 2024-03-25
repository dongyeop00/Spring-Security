package com.gdy.springsecurity.Controller;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collection;
import java.util.Iterator;

@Controller
public class HomeController {

    @GetMapping("/")
    public String home(Model model){

        // 사용자의 인증 정보에 접근하여 인증 정보를 반환 후 Authentication 객체에서 사용자의 이름을 반환하는 메서드
        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        // SecurityContextHolder를 사용하여 현재 스레드의 보안 컨텍스트를 가져온다. 그리고 getAuthentication을 호출하여 현재 사용자의 인증 정보를 가져온다.
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        // getAuthorities()를 호출하여 현재 사용자의 권한 목록을 가져온다. 이 메서드는 사용자가 가진 모든 권한을 나타내는 GrantedAuthority 객체의 컬렉션을 반환한다.
        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();

        // authorities 컬렉션에 대한 반복자를 얻는다.
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();

        // iter.next() 반복자를 사용하여 다음 권한(GrantedAuthority)을 가져온다. 보통 사용자는 여러 권한을 가질 수 있지만 이 코드에서는 첫 번째 권한만 가져온다.
        GrantedAuthority auth = iter.next();

        // getAuthority 메서드를 사용하여 현재 권한의 문자열 표현을 가져온다.
        String role = auth.getAuthority();

        model.addAttribute("id",id);
        model.addAttribute("role",role);
        return "index";
    }



}
