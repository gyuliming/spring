package com.ssg.webmvcboard.mapper;

import com.ssg.webmvcboard.domain.BoardVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BoardMapper {
    void insert(BoardVO boardVO);
    List<BoardVO> selectAll();
    BoardVO selectOne(Long tno);
    void updateViewCount(Long tno);
    void update(BoardVO boardVO);
    void delete(Long tno);
    String selectPassphrase(Long tno);
}
