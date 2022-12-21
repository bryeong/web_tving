package com.example.tving.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Log4j2
@Controller
public class MainController {
    @Autowired
    MainService mainService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/main")
    public void main_get(Model model){
        log.info(" -------- main_get ---------- ");
        log.info(" -------- 로그인 했을 시 메인 화면 ---------- ");
        //만약 로그인 하였다 -> 로그인 시 메인 화면으로 이동
        model.addAttribute("recommended_programs", mainService.get_recommended_programs());
        //만약 로그인 하지 않았음 -> 로그인 안했을 시의 홈 화면으로 이동
    }

    @GetMapping("/main/program/{name}")
    public void program_get(@PathVariable String name){

    }

}
