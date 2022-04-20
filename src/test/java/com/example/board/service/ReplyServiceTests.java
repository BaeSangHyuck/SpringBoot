package com.example.board.service;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class ReplyServiceTests {
    @Setter(onMethod_ = @Autowired)
    private ReplyService service;

    private Long[] arBno = {12582997L, 12582996L, 12582995L, 12582994L, 12582993L};

//    @Test
//    public void testGetTotal(){
//        log.info("------------------------------------------------------");
//        log.info(String.valueOf(service.getTotal(12582996L)));
//        log.info("------------------------------------------------------");
//    }

//    @Test
//    public void testGetList(){
//        log.info("------------------------------------------------------");
//        service.getList(12582996L, new Criteria(1, 10)).stream().map(v -> v.toString()).forEach(log::info);
//        log.info("------------------------------------------------------");
//    }

//    @Test
//    public void testModify(){
//        ReplyVO replyVO = new ReplyVO();
//        replyVO.setRno(3L);
//        replyVO.setReply("수정된 댓글2");
//
//        if(service.read(replyVO.getRno()) != null) {
//            log.info("------------------------------------------------------");
//            log.info("UPDATE : " + service.modify(replyVO));
//            log.info("------------------------------------------------------");
//            return;
//        }
//        log.info("There is no reply to update");
//    }

//    @Test
//    public void testRemove(){
//        if(service.read(4L) != null) {
//            log.info("------------------------------------------------------");
//            log.info("DELETE : " + service.remove(4L));
//            log.info("------------------------------------------------------");
//            return;
//        }
//        log.info("There is no reply to delete");
//    }

//    @Test
//    public void testRead(){
//        log.info("------------------------------------------------------");
//        log.info(service.read(2L).toString());
//        log.info("------------------------------------------------------");
//    }

//    @Test
//    //단위 테스트에서는 5개의 게시글에 2개씩 댓글 등록 (람다식)
//    public void testRegister(){
//        IntStream.rangeClosed(11, 20).forEach(i -> {
//            ReplyVO replyVO = new ReplyVO();
//            replyVO.setBno(arBno[i % 5]);
//            replyVO.setReply("댓글 테스트" + i);
//            replyVO.setReplier("replier" + i);
//
//            log.info("INSERT : " + service.register(replyVO));
//        });
//    }
}
