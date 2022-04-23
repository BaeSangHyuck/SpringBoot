package com.example.board.domain.dao;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import com.example.board.mapper.ReplyMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
@Slf4j
public class ReplyDAO {
    private final ReplyMapper replyMapper;

    public int register(ReplyVO replyVO){
        log.info("reply register........." + replyVO);
        return replyMapper.insert(replyVO);
    }

    public ReplyVO read(Long bno){
        log.info("reply read........." + bno);
        return replyMapper.read(bno);
    }

    public int remove(Long rno){
        log.info("reply remove........." + rno);
        return replyMapper.delete(rno);
    }

    public int modify(ReplyVO replyVO){
        log.info("reply modify........." + replyVO);
        return replyMapper.update(replyVO);
    }

    public List<ReplyVO> getList(Long bno, Criteria criteria){
        log.info("get reply list......." + bno);
        return replyMapper.getList(bno, criteria);
    }

    public int getTotal(Long bno){
        log.info("reply get total........");
        return replyMapper.getTotal(bno);
    }

}













