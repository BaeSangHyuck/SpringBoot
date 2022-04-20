package com.example.board.mapper;

import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardMapperTests {
    @Autowired
    private BoardMapper boardMapper;

//    @Test
//    public void testInsertSelectBno(){
//        BoardVO boardVO = new BoardVO();
//        boardVO.setTitle("테스트 제목");
//        boardVO.setContent("테스트 내용");
//        boardVO.setWriter("user00");
//
//        boardMapper.insertSelectBno(boardVO);
//
//        log.info("---------------------------------------------------------------------");
//        log.info(boardVO.toString());
//        log.info("---------------------------------------------------------------------");
//    }

//    @Test
//    public void testGetTotal(){
//        log.info("---------------------------------");
//        log.info("TOTAL : " + String.valueOf(boardMapper.getTotal()));
//        log.info("---------------------------------");
//    }

//    @Test
//    public void testGet(){
//        log.info(boardMapper.get(2L).toString());
//    }

//    @Test
//    public void testDelete(){
//        int result = 0;
//        Long bno = 1L;
//        result = boardMapper.delete(bno);
//
//        log.info("DELETE COUNT : " + result);
//    }

//    @Test
//    public void testUpdate(){
//        int result = 0;
//
//        BoardVO boardVO = new BoardVO();
//        boardVO.setBno(2L);
//        boardVO.setTitle("수정된 제목");
//        boardVO.setContent("수정된 내용");
//
//        result = boardMapper.update(boardVO);
//        log.info("UPDATE COUNT : " + result);
//    }

//    @Test
//    public void testInsert(){
//        BoardVO boardVO = new BoardVO();
//        boardVO.setTitle("테스트 제목2");
//        boardVO.setContent("테스트 내용2");
//        boardVO.setWriter("user01");
//
//        boardMapper.insert(boardVO);
//    }

    @Test
    public void testGetList(){
        boardMapper.getList(new Criteria(1, 10, "TCW", "한동석")).forEach(board -> log.info(board.toString()));
    }
}












