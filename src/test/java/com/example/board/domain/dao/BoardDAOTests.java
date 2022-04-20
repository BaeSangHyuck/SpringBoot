package com.example.board.domain.dao;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardDAOTests {
    @Autowired
    private BoardDAO boardDAO;

//    @Test
//    public void testGetTotal(){
//        log.info("---------------------------------");
//        log.info("TOTAL : " + String.valueOf(boardDAO.getTotal()));
//        log.info("---------------------------------");
//    }

//    @Test
//    public void testGet(){
//        log.info(boardDAO.get(2L).toString());
//    }

//    @Test
//    public void testRemove(){
//        boolean result = false;
//        BoardVO boardVO = boardDAO.get(6L);
//        if(boardVO != null){
//            result = boardDAO.remove(boardVO.getBno());
//        }
//        log.info("DELETE : " + result);
//    }

//    @Test
//    public void testModify(){
//        boolean result = false;
//        //해당 게시글이 있는 지 검사한 뒤 제목만 수정
//        BoardVO boardVO = boardDAO.get(6L);
//        if(boardVO != null){
//            boardVO.setTitle("테스트 제목2");
//            result = boardDAO.modify(boardVO);
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
//        boardDAO.register(boardVO);
//
//        log.info("---------------------------------------------------------------------");
//        log.info(boardVO.toString());
//        log.info("BNO : " + boardVO.getBno());
//        log.info("---------------------------------------------------------------------");
//    }

    @Test
    public void testGetList(){
        boardDAO.getList(new Criteria(3, 10)).forEach(board -> log.info(board.toString()));
    }
}












