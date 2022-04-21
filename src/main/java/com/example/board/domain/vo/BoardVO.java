package com.example.board.domain.vo;

import lombok.Data;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Data
public class BoardVO {
    private Long bno;
    private String title;
    private String content;
    private String writer;
    private String regdate;
    private String updateDate;
    private List<AttachVO> attachVOList;
    private Long replyCount;
}
