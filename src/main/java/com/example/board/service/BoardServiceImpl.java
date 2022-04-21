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

    @Transactional
    @Override
    public boolean modify(BoardVO boardVO) {
        attachDAO.remove(attachDAO.getUUID(boardVO.getBno()));
        boolean check = boardDAO.modify(boardVO);
        if(check){
            boardVO.getAttachVOList().forEach(attach -> {
                attach.setBno(boardVO.getBno());
                attachDAO.register(attach);
            });
        }
        return check;
    }

    @Transactional
    @Override
    public boolean remove(Long bno) {
        //해당 게시글의 첨부파일들은 공통된 UUID가 있으며,
        //UUID로 첨부파일을 삭제하면 DBMS쪽에서 처리가 되기 때문에
        //JAVA 단에서는 반복을 돌릴 필요가 없다.
//        attachDAO.remove(attachDAO.getUUID(bno)); // RDB에서 ON DELETE CASCADE 명령어를 통해 직접 처리할 필요가 없다.
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
