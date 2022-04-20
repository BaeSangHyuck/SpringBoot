package com.example.board.mapper;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.stream.IntStream;

@SpringBootTest
@Slf4j
public class ReplyMapperTests {
    @Setter(onMethod_ = @Autowired)
    private ReplyMapper mapper;

    private Long[] arBno = {12582997L, 12582996L, 12582995L, 12582994L, 12582993L};

//    @Test
//    public void testGetTotal(){
//        log.info("------------------------------------------------------");
//        log.info(String.valueOf(mapper.getTotal(12582997L)));
//        log.info("------------------------------------------------------");
//    }

    @Test
    public void testGetList(){
        log.info("------------------------------------------------------");
        mapper.getList(12582996L, new Criteria(1, 10)).stream().map(v -> v.toString()).forEach(log::info);
        log.info("------------------------------------------------------");
    }

//    @Test
//    public void testUpdate(){
//        ReplyVO replyVO = new ReplyVO();
//        replyVO.setRno(4L);
//        replyVO.setReply("수정된 댓글");
//
//        if(mapper.read(replyVO.getRno()) != null) {
//            log.info("------------------------------------------------------");
//            log.info("UPDATE COUNT : " + mapper.update(replyVO));
//            log.info("------------------------------------------------------");
//            return;
//        }
//        log.info("There is no reply to update");
//    }

//    @Test
//    public void testDelete(){
//        if(mapper.read(5L) != null) {
//            log.info("------------------------------------------------------");
//            log.info("DELETE COUNT : " + mapper.delete(5L));
//            log.info("------------------------------------------------------");
//            return;
//        }
//        log.info("There is no reply to delete");
//    }

//    @Test
//    public void testRead(){
//        log.info("------------------------------------------------------");
//        log.info(mapper.read(5L).toString());
//        log.info("------------------------------------------------------");
//    }

//    @Test
//    //단위 테스트에서는 5개의 게시글에 2개씩 댓글 등록 (람다식)
//    public void testInsert(){
//        IntStream.rangeClosed(1, 10).forEach(i -> {
//            ReplyVO replyVO = new ReplyVO();
//            replyVO.setBno(arBno[i % 5]);
//            replyVO.setReply("댓글 테스트" + i);
//            replyVO.setReplier("replier" + i);
//
//            mapper.insert(replyVO);
//        });
//    }

//    @Test
//    public void testMapper(){
//        log.info("------------------------------------------------------");
//        log.info("mapper : " + mapper.toString());
//        log.info("------------------------------------------------------");
//    }

}
