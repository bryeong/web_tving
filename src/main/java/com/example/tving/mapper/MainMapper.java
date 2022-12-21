package com.example.tving.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface MainMapper {
    //메인 화면에서 실시간 뜨는 콘텐츠(프로그램)의 이름들을 가져옴
    List<String> get_recommended_programs();
    //프로그램 이름으로 하나의 프로그램의 정보를 가져옴
    ProgramVO get_program(String name);
    //프로그램 이름으로 하나의 프로그램의 각 회차 정보를 가져옴
    List<ContentsVO> get_program_contents(String name);

}
