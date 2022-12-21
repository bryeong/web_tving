package com.example.tving.controller;

import com.example.tving.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Log4j2
@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping("/login")
    public void user(){

    }
    @PostMapping("/login")
    public String login_post(String username, String password){
        log.info(" ----------- login 시도: login_post ---------- ");
        log.info(" ----------- login 시도: " + username + "/" + password);
        //만약 로그인이 성공했다면 무조건 메인 화면으로 이동해야 함
        return "redirect:/main";
    }

    @GetMapping("/register")
    public void register_get(){}

    @PermitAll
    @PostMapping("/register")
    public void register_post(UserVO vo){
        log.info(" ------- register_post ----------");
        log.info(vo);
        userService.register(vo);
    }


    @PreAuthorize("isAuthenticated()")
    @GetMapping("/info")
    public void info_get(){

    }

    @PostMapping("/info")
    public String info_post(UserVO vo){
        log.info(" ------------------- info_post ------------- ");
        log.info(vo);
        userService.modify_user(vo);
        return "redirect:/main";
    }

}
