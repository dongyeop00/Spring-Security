package com.gdy.springsecurity.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {

    @GetMapping("/lgoin")
    public String loginP(){
        return "login";
    }

}
