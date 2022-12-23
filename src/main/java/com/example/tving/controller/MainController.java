package com.example.tving.controller;

import com.example.tving.dtos.UserDTO;
import com.example.tving.service.MainService;
import com.example.tving.service.UserService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Log4j2
@Controller
public class MainController {
    @Autowired
    MainService mainService;
    @Autowired
    UserService userService;

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/main")
    public void main_get(@AuthenticationPrincipal UserDetails principal, Model model){
        log.info(" -------- main_get ---------- ");
        log.info(" -------- 로그인 했을 시 메인 화면 ---------- ");
        log.info(principal);
        //만약 로그인 하였다 -> 로그인 시 메인 화면으로 이동
        model.addAttribute("recommended_programs", mainService.get_recommended_programs());
        //만약 로그인 하지 않았음 -> 로그인 안했을 시의 홈 화면으로 이동
    }

    @PreAuthorize("isAuthenticated()")
    //메인화면에서 프로그램명 클릭했을 때 프로그램 상세 페이지로 이동하는 부분
    @GetMapping("/main/program/{name}")
    public String program_get(
            @AuthenticationPrincipal UserDTO userDTO,
            @PathVariable String name,
            Model model
    ){
        //해당 유저의 시청내역
        model.addAttribute("watchVO", userService.get_watch_program_order(userDTO.getId(), name));
        //해당 프로그램의 정보
        model.addAttribute("program", mainService.get_program(name));
        //해당 프로그램의 회차 정보
        model.addAttribute("contents", mainService.get_program_contents(name));
        //해당 페이지로 이동
        return "/main/program";
    }

    @PreAuthorize("isAuthenticated()")
    //프로그램 상세 페이지에서 프로그램 시청 버튼 눌렀을 때 - 시청 내역 추가하기
    @GetMapping("/main/program/watch/{name}/{order}")
    public String program_watch_get(
            @PathVariable String name,
            @PathVariable int order,
            @AuthenticationPrincipal UserDTO userDTO
    ){
        log.info(" --------- program_watch_get -------- ");
        log.info(userDTO);
        if(userDTO.getRole().equals("USER")){
            return "redirect:/user/membership";
        }

        //시청 내역에 해당 프로그램 추가하기
        log.info("시청하려는 프로그램명: " + name);
        log.info("시청하려는 유저: " + userDTO.getId());
        mainService.insert_watched_program(userDTO.getId(), name, order);
        //원래는 시청하러 가야하지만 현재는 마이페이지로 이동하도록 함
        return "redirect:/user/mypage/main";
    }
}
