package com.example.board.controller;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyPageDTO;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.service.BoardService;
import com.example.board.service.ReplyService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Optional;

/*
* REST(Representational State Transfer)
*
*   하나의 URI는 하나의 고유한 리소스를 대표하도록 설계된다.
*   예)/board/123 : 게시물 중 123번
* */

@RestController
@Slf4j
@RequiredArgsConstructor
@RequestMapping("/replies/*")
public class ReplyController {
    private final ReplyService replyService;

//    댓글 등록
//    브라우저에서 JSON타입으로 데이터를 전송하고 서버에서는 댓글의 처리 결과에 따라 문자열로 결과를 리턴한다.
//    consumes : 전달받은 데이터의 타입
//    produces : 콜백함수로 결과를 전달할 때의 타입
//    @RequestBody : 전달받은 데이터를 알맞는 매개변수로 주입할 때 사용
//    ResponseEntity : 서버의 상태코드, 응답 메세지 등을 담을 수 있는 타입
    @PostMapping(value = "/new", consumes = "application/json", produces = "text/plain; charset=utf-8")
    public ResponseEntity<String> create(@RequestBody ReplyVO replyVO) throws UnsupportedEncodingException {
        log.info("replyVO : " + replyVO);
        return replyService.register(replyVO) ? new ResponseEntity<>(new String("댓글 등록 성공".getBytes(), "UTF-8"), HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }

//    게시글 댓글 전체 조회
    @GetMapping("/list/{bno}/{pageNum}")
    public ReplyPageDTO getList(@PathVariable("bno") Long bno, @PathVariable("pageNum") int pageNum){
        log.info("getList.........." + bno + ", " + pageNum);
        return new ReplyPageDTO(replyService.getTotal(bno), replyService.getList(bno, new Criteria(pageNum, 10)));
    }
    
//    댓글 1개 조회
    @GetMapping("/{rno}")
    public ReplyVO read(@PathVariable("rno") Long rno){
        log.info("read............" + rno);
        return replyService.read(rno);
    }

//    댓글 삭제
    @DeleteMapping("/{rno}")
    public String remove(@PathVariable("rno") Long rno){
        log.info("remove............" + rno);
        return replyService.remove(rno) ? "댓글 삭제 성공" : "댓글 삭제 실패";
    }

//    댓글 수정
//    PUT : 자원의 전체 수정, 자원 내 모든 필드를 전달해야 함, 일부만 전달할 경우 오류
//    PATCH : 자원의 일부 수정, 수정할 필드만 전송(자동 주입이 아닌 부분만 수정하는 쿼리문에서 사용)
//    PATCH가 PUT을 담고 있기 때문에 전체를 전달받아서 전체를 수정하는 상황, 전체 중 부분만 수정하는 상황 모두 PATCH를 사용하는 것이 좋다.
//    @PutMapping(value = "/{rno}", consumes = "application/json")
    @PatchMapping(value = {"/{rno}", "/{rno}/{replier}"}, consumes = "application/json")

//    value = {"/{rno}", "/{rno}/{replier}"}
//    ↑ 외부에서 데이터가 전달될 때 일부분만 전달하면 그 에 따른 URI를 위와 같이 구분해준다.
//    ReplyVO에 전달될 JSON 데이터 중 replier가 전달되지 않았을 경우 Validate, Validated, Valid 등을 사용하여 검증 단계를 거쳐야 한다.
//    하지만 복잡하고, 이걸 쓸바에 POST를 쓰기 때문에 현장에서 잘 사용하지 않는다.
//    만약 null에 대한 검사를 하고자 한다면 객체 안의 필드를 매개변수로 따로 설정하여, null을 허용하고(required=false),
//    null 검사는 Optional의 ofNullable()을 통해 진행한다. null일 경우에는 orElse()를 사용하여 대체 값을 설정해준다.
    public String modify(@RequestBody ReplyVO replyVO, @PathVariable(value = "replier", required = false) String replier, @PathVariable("rno") Long rno){
        log.info("modify.........." + replyVO);
        if(replyVO.getReplier() == null){ //json 검증
            replyVO.setReplier(Optional.ofNullable(replier).orElse("anonymous")); //uri 검증
        }
        replyVO.setRno(rno);
        return replyService.modify(replyVO) ? "댓글 수정 성공" : "댓글 수정 실패";
    }

    @GetMapping("/total/{bno}")
    public Integer getTotal(@PathVariable Long bno){
        return replyService.getTotal(bno);
    }
}






















