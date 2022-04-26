package com.example.board.mapper;

import com.example.board.domain.vo.Criteria;
import com.example.board.domain.vo.ReplyVO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ReplyMapper {
    //댓글 등록(insert)
    public int insert(ReplyVO replyVO);

    //댓글 1개 조회(read)
    public ReplyVO read(Long rno);

    //댓글 1개 삭제(delete)
    public int delete(Long rno);

    //댓글 1개 수정(update)
    public int update(ReplyVO replyVO);

    //댓글 목록(getList)
//    기존의 게시물 페이징 처리 + 특정 게시물 번호를 전달해야 한다.
//    MyBatis에 두 개 이상의 데이터를 파라미터로 전달할 때에는
//    별도의 객체로 구성하거나 Map을 이용, @Param을 이용한다.
//    2.6.6버전에서는 처리를 안해도 자동으로 매핑된다.
//    public List<ReplyVO> getList(@Param("bno") Long bno, @Param("criteria") Criteria criteria);
    public List<ReplyVO> getList(Long bno, Criteria criteria);

    //댓글 개수(getTotal)
    public int getTotal(Long bno);
}
