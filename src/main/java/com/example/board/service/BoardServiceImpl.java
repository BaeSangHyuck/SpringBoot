package com.example.board.service;

import com.example.board.domain.dao.AttachDAO;
import com.example.board.domain.dao.BoardDAO;
import com.example.board.domain.vo.AttachVO;
import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{

    private final BoardDAO boardDAO;
    private final AttachDAO attachDAO;

    @Override
    public List<BoardVO> getList(Criteria criteria) {
        return boardDAO.getList(criteria);
    }

    @Override
    public List<AttachVO> getList(Long bno) {
        return attachDAO.selectAllByBno(bno);
    }

    @Transactional
    @Override
    public void register(BoardVO boardVO) {
        boardDAO.register(boardVO);
        if(boardVO.getAttachVOList() != null) {
            boardVO.getAttachVOList().forEach(attachVO -> {
                attachVO.setBno(boardVO.getBno());
                attachDAO.register(attachVO);
            });
        }
    }

    @Override
    public boolean modify(BoardVO boardVO) {
        return boardDAO.modify(boardVO);
    }

    @Override
    public boolean remove(Long bno) {
        return boardDAO.remove(bno);
    }

    @Override
    public BoardVO get(Long bno) {
        return boardDAO.get(bno);
    }

    @Override
    public int getTotal(Criteria criteria) {
        return boardDAO.getTotal(criteria);
    }
}
