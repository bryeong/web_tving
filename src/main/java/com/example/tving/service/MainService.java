package com.example.tving.service;

import com.example.tving.mapper.MainMapper;
import com.example.tving.vos.ContentsVO;
import com.example.tving.vos.ProgramVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService {
    @Autowired
    private MainMapper mainMapper;
    // 메인화면에서 추천 프로그램들을 가져옴
    public List<String> get_recommended_programs(){
        return mainMapper.get_recommended_programs();
    }
    // 프로그램 이름으로 하나의 프로그램의 정보를 가져옴
    public ProgramVO get_program(String name){
        return mainMapper.get_program(name);
    }

    // 프로그램 이름으로 하나의 프로그램의 각 회차 정보를 가져옴
    public List<ContentsVO> get_program_contents(String name){
        return mainMapper.get_program_contents(name);
    }

    // 시청 버튼을 눌렀을 시 시청 내역에 추가 (프로그램 이름)
    public boolean insert_watched_program(String id, String name, int order){
        return mainMapper.insert_watched_program(id, name, order);
    }


}
