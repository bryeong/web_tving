package com.example.tving.service;

import com.example.tving.dtos.UserDTO;
import com.example.tving.mapper.UserMapper;
import com.example.tving.vos.UserVO;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Log4j2
@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        log.info(" ----------- loadUserByUsername -------------------- ");
        log.info(username + "이 로그인 시도 하였습니다!");

        UserVO userVO = userMapper.find_user(username);

        if(userVO == null){
            throw new UsernameNotFoundException(username + ": ------ 해당 유저는 존재하지 않음! --------- ");
        }

        log.info("유저를 찾았습니다!");

        return (UserDetails) new UserDTO(
                username,
                userVO.getPassword(),
                userVO.getName(),
                userVO.getNickName(),
                userVO.getEmail(),
                userVO.getTel(),
                userVO.getRegisterDate(),
                userVO.isSocial(),
                userVO.getRole(),
                Collections.singleton(new SimpleGrantedAuthority("ROLE_" + userVO.getRole()))
        );
    }
}
