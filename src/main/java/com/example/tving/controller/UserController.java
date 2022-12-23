package com.example.tving.controller;

import com.example.tving.dtos.UserDTO;
import com.example.tving.service.UserService;
import com.example.tving.vos.UserVO;
import com.example.tving.vos.WatchVO;
import jakarta.annotation.security.PermitAll;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    // 마이페이지 메인 화면
    @GetMapping("/mypage/main")
    public void mypage_get(){

    }

    // 마이페이지 - 회원 시청내역 전부 가져오기
    @PreAuthorize("isAuthenticated()")
    @ResponseBody
    @GetMapping("/mypage/main/watch")
    public List<WatchVO> all_watch_program_get(
            @AuthenticationPrincipal UserDTO userDTO
            ){
        return userService.get_all_watch_program_list(userDTO.getId());
    }

    // 마이페이지 - 회원정보 수정 페이지 이동
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/info")
    public void info_get(){

    }

    // 마이페이지 - 회원정보 수정하기
    @PreAuthorize("isAuthenticated()")
    @GetMapping("/mypage/info")
    public String info_post(
            @AuthenticationPrincipal UserDTO userDTO,
            UserVO vo
    ){
        log.info(" ----------------- info_post ----------------");
        log.info(vo);
        if(userService.modify_user(vo)) {
            userDTO.setTel(vo.getTel());
            userDTO.setEmail(vo.getEmail());
        }
        return "redirect:/user/mypage/main";
    }

    @PreAuthorize("isAuthenticated()")
    @GetMapping("/membership")
    public void membership_get(){

    }

    // 사용자가 이용권을 구매하는 곳
    @PreAuthorize("isAuthenticated()")
    @PostMapping("/membership")
    public String membership_post(@AuthenticationPrincipal UserDTO userDTO){
        // 현재 이용권 정보를 체크
        // 이용권을 사는 로직
        // 권한을 upgrade 시킴 user -> basic
        userService.modify_membership(userDTO.getId(), "BASIC");
        userDTO.setRole("BASIC");
        return "redirect:/main";
    }

}
