package com.example.board.domain.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
@AllArgsConstructor
public class ReplyPageDTO {
    private int replyCount;
    private List<ReplyVO> list;

    /*
    * 기본 생성자를 사용하면 final 필드는 초기화 되지 않기 때문에 오류가 발생한다.
    * 이 때에는 final을 없애주고
    * @AllArgsConstructor를 사용하여 어떤 생성자를 호출하더라도 오류가 발생하지 않는다.
    * */
    public ReplyPageDTO() {;}
}














