package com.example.board.service;


import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;

@Slf4j
@SpringBootTest
public class BoardServiceTest {
    @Autowired
    private BoardService boardService;

    @Test
    public void testGetTotal(Criteria criteria){
        criteria.setType("TW");
        criteria.setKeyword("수");
        criteria.getTypes();
        log.info("---------------------------------");
        log.info("TOTAL : " + String.valueOf(boardService.getTotal(criteria)));
        log.info("---------------------------------");
    }

//    @Test
//    public void testGet(){
//        log.info(boardService.get(1L).toString());
//    }

//    @Test
//    public void testRemove(){
//        boolean result = false;
//        BoardVO boardVO = boardService.get(1L);
//        if(boardVO != null){
//            result = boardService.remove(boardVO.getBno());
//        }
//        log.info("DELETE : " + result);
//    }

//    @Test
//    public void testModify(){
//        boolean result = false;
//        //해당 게시글이 있는 지 검사한 뒤 제목만 수정
//        BoardVO boardVO = boardService.get(8L);
//        if(boardVO != null){
//            boardVO.setTitle("수정된 제목2");
//            result = boardService.modify(boardVO);
//        }
//        log.info("UPDATE : " + result);
//    }

//    @Test
//    public void testRegister(){
//        BoardVO boardVO = new BoardVO();
//        boardVO.setTitle("테스트 제목3");
//        boardVO.setContent("테스트 내용3");
//        boardVO.setWriter("user03");
//
//        boardService.register(boardVO);
//
//        log.info("---------------------------------------------------------------------");
//        log.info(boardVO.toString());
//        log.info("BNO : " + boardVO.getBno());
//        log.info("---------------------------------------------------------------------");
//    }

//    @Test
//    public void testGetList(){
//        boardService.getList(new Criteria()).forEach(board -> log.info(board.toString()));
//    }
}
