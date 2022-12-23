package com.example.tving.service;

import com.example.tving.mapper.UserMapper;
import com.example.tving.vos.UserVO;
import com.example.tving.vos.WatchVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    // 유저 회원가입
    public boolean register(UserVO vo){
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        return userMapper.register(vo);
    }

    // 유저 로그인
    public UserVO login(String username){
        return userMapper.find_user(username);
    }

    // 유저 정보 수정
    public boolean modify_user(UserVO vo){
        return userMapper.modify_user(vo);
    }

    // 유저 멤버십 정보를 수정
    public boolean modify_membership(String userID, String role){
        return userMapper.modify_membership(userID, role);
    }

    //해당 유저가 시청한 하나의 프로그램의 회차정보를 가져옴
    public WatchVO get_watch_program_order(String userID, String programName){
        return userMapper.get_watch_program_order(userID, programName);
    }

    //유저 아이디를 전달하여 유저의 시청내역을 가져옴
    public List<WatchVO> get_all_watch_program_list(String id){
        return userMapper.get_all_watch_program_list(id);
    }
}
