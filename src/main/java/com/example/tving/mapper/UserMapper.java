package com.example.tving.mapper;

import com.example.tving.vos.UserVO;
import com.example.tving.vos.WatchVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface UserMapper {
    //처음 회원가입 시도 시
    boolean register(UserVO vo);
    //로그인 시도 시 해당 ID에 해당하는 유저를 찾음
    UserVO find_user(@Param("id") String userID);
    // 유저 정보를 전달하여 유저의 정보를 수정함
    boolean modify_user(UserVO vo);
    // 유저의 권한을 수정
    boolean modify_membership(@Param("id")String userID, @Param("role")String role);

    //해당 유저가 시청한 하나의 프로그램의 회차정보를 가져옴
    WatchVO get_watch_program_order(@Param("id") String userID, @Param("name")String programName);
    //유저 아이디를 전달하여 유저의 시청내역을 가져옴
    List<WatchVO> get_all_watch_program_list(@Param("id") String userID);


}
