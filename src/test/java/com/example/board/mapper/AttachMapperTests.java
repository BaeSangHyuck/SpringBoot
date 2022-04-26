package com.example.board.mapper;

import com.example.board.domain.vo.AttachVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class AttachMapperTests {
    @Autowired
    private AttachMapper attachMapper;

    @Test
    public void testDelete(){
        attachMapper.delete("몰라");
    }

//    @Test
//    public void testSelect(){
//        attachMapper.select(12582997L).stream().map(AttachVO::toString).forEach(log::info);
//    }

//    @Test
//    public void testInsert(){
//        AttachVO attachVO = new AttachVO();
//        attachVO.setFileName("day05.txt");
//        attachVO.setUuid("몰라");
//        attachVO.setUploadPath("2022/04/19");
//        attachVO.setImage(false);
//        attachVO.setBno(12582997L);
//        attachMapper.insert(attachVO);
//    }
}
