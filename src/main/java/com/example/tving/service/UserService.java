package com.example.tving.service;

import com.example.tving.mapper.UserMapper;
import com.example.tving.vos.UserVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    //유저 회원가입
    public boolean register(UserVO vo){
        vo.setPassword(passwordEncoder.encode(vo.getPassword()));
        return userMapper.register(vo);
    }

    //유저 로그인
    public UserVO login(String username){
        return userMapper.find_user(username);
    }

    public boolean modify_user(UserVO vo){
        return userMapper.modify_user(vo);
    }



}
