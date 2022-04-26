package com.example.board.mapper;

import com.example.board.domain.vo.BoardVO;
import com.example.board.domain.vo.Criteria;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
//    게시글 목록
    public List<BoardVO> getList(Criteria criteria);

//    게시글 작성
    public void insert(BoardVO boardVO);

//    게시글 작성
//    selectKey를 통해서 전달된 결과는 boardVO 필드에 매핑된 후 주입된다.
    public void insertSelectBno(BoardVO boardVO);

//    게시글 수정
    public int update(BoardVO boardVO);

//    게시글 삭제
    public int delete(Long bno);

//    특정 게시글 가져오기
    public BoardVO get(Long bno);

//    전체 게시글 개수
    public int getTotal(Criteria criteria);

//    게시글에 작성된 댓글 수 수정
    public void updateReplyCount(Long bno, int status);
}
