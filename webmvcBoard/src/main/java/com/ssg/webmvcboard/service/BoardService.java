package com.ssg.webmvcboard.service;

import com.ssg.webmvcboard.dto.BoardDTO;

import java.util.List;

public interface BoardService {
    void register(BoardDTO boardDTO);
    List<BoardDTO> getAll();
    BoardDTO getOne(Long tno);
    void increaseViewCount(Long tno);
    void modify(BoardDTO boardDTO);
    void remove(Long tno);
//    boolean checkPassphrase(Long tno, String passphrase);
}
