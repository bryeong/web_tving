package com.example.tving.mapper;

import org.apache.ibatis.annotations.Param;

public interface UserMapper {
    //처음 회원가입 시도 시
    boolean register(UserVO vo);
    //로그인 시도 시 해당 ID에 해당하는 유저를 찾음
    UserVO find_user(@Param("id") String username);

    boolean modify_user(UserVO vo);


}
