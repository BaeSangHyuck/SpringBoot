package com.example.board.service;

import com.example.board.domain.vo.AttachVO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class BoardServiceTests {
    @Autowired
    private BoardService boardService;

    @Test
    public void testGetList(){
        boardService.getList(12583010L).stream().map(AttachVO::toString).forEach(log::info);
    }

//    @Test
//    public void testGetTotal(){
//        log.info("---------------------------------");
//        log.info("TOTAL : " + String.valueOf(boardService.getTotal()));
//        log.info("---------------------------------");
//    }

//    @Test
//    public void testGet(){
//        log.info(boardService.get(2L).toString());
//    }

//    @Test
//    public void testRemove(){
//        boolean result = false;
//        BoardVO boardVO = boardService.get(2L);
//        if(boardVO != null){
//            result = boardService.remove(boardVO.getBno());
//        }
//        log.info("DELETE : " + result);
//    }

//    @Test
//    public void testModify(){
//        boolean result = false;
//        //해당 게시글이 있는 지 검사한 뒤 제목만 수정
//        BoardVO boardVO = boardService.get(7L);
//        if(boardVO != null){
//            boardVO.setTitle("수정된 제목2");
//            result = boardService.modify(boardVO);
//        }
//        log.info("UPDATE : " + result);
//    }

//    @Test
//    public void testRegister(){
//        BoardVO boardVO = new BoardVO();
//        boardVO.setTitle("테스트 제목2");
//        boardVO.setContent("테스트 내용2");
//        boardVO.setWriter("user02");
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
//        boardService.getList(new Criteria(4, 10)).forEach(board -> log.info(board.toString()));
//    }
}












