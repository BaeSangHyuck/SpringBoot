package com.example.board.mapper;

import com.example.board.domain.vo.AttachVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AttachMapper {
    public void insert(AttachVO attachVO);
    public void delete(String uuid);
    public List<AttachVO> select(Long bno);
}
