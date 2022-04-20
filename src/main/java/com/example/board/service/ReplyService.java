package com.example.board.service;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ReplyService {
    public boolean register(ReplyVO replyVO);
    public ReplyVO read(Long rno);
    public boolean remove(Long rno);
    public boolean modify(ReplyVO replyVO);
    public List<ReplyVO> getList(Long bno, Criteria criteria);
    public int getTotal(Long bno);
}
