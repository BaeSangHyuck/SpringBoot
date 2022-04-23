package com.example.board.domain.dao;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import com.example.board.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class BoardDAO {
    private final BoardMapper boardMapper;

    public List<BoardVO> getList(Criteria criteria) {return boardMapper.getList(criteria);}
    public void register(BoardVO boardVO) {boardMapper.insertSelectBno(boardVO);}
    public boolean modify(BoardVO boardVO) {return boardMapper.update(boardVO) == 1;}
    public boolean remove(Long bno) {return boardMapper.delete(bno) == 1;}
    public BoardVO get(Long bno) {return boardMapper.get(bno);}
    public int getTotal(Criteria criteria) {return boardMapper.getTotal(criteria);}
    public void updateReplyCount(Long bno, int status) {boardMapper.updateReplyCount(bno, status);}
}
