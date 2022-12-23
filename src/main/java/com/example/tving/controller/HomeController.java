package com.example.tving.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
//import javax.annotation.security.PermitAll;

@Log4j2
@Controller
public class HomeController {
    @GetMapping("/")
    public String home(@AuthenticationPrincipal UserDetails userDetails){
        log.info(" -------------- home ----------- ");
        if(userDetails == null){
            log.info(" ----------- 로그인 되지 않았음! ------");
            log.info(" ----------- 티빙 로그인 안했을 시 홈 화면으로 이동 ------");
            return "redirect:/home";
        }
        log.info(" ----------- 로그인 되었음 ------");
        log.info(" 로그인 정보:" + userDetails);
        log.info(" ----------- 티빙 메인 화면으로 이동 ------");

        return "redirect:/main";
    }

    @GetMapping("/home")
    public void home_get(){

    }

    @GetMapping("/login")
    public void login(){

    }
}
