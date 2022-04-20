package com.example.board.domain.dao;

import com.example.board.domain.vo.AttachVO;
import com.example.board.mapper.AttachMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class AttachDAO {
    private final AttachMapper attachMapper;

    public void register(AttachVO attachVO){
        attachMapper.insert(attachVO);
    }

    public void remove(String uuid){
        attachMapper.delete(uuid);
    }

    public List<AttachVO> selectAllByBno(Long bno){
        return attachMapper.select(bno);
    }
}
