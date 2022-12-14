package com.example.tving.mapper;

import com.example.tving.vos.ContentsVO;
import com.example.tving.vos.ProgramVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MainMapper {
    //메인 화면에서 실시간 뜨는 콘텐츠(프로그램)의 이름들을 가져옴
    List<String> get_recommended_programs();
    //프로그램 이름으로 하나의 프로그램의 정보를 가져옴
    ProgramVO get_program(String name);
    //프로그램 이름으로 하나의 프로그램의 각 회차 정보를 가져옴
    List<ContentsVO> get_program_contents(String name);

    // 시청 버튼을 눌렀을 시 시청 내역에 추가 (프로그램 이름)
    boolean insert_watched_program(
            @Param("id") String id,
            @Param("name") String name,
            @Param("order") int order
    );
}
