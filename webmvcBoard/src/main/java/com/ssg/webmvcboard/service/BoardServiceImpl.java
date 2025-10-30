package com.ssg.webmvcboard.service;

import com.ssg.webmvcboard.domain.BoardVO;
import com.ssg.webmvcboard.dto.BoardDTO;
import com.ssg.webmvcboard.mapper.BoardMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Log4j2
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
    private final BoardMapper boardMapper;
    private final ModelMapper modelMapper;

    @Override
    public void register(BoardDTO boardDTO) {
        log.info("register service");
        BoardVO boardVO = modelMapper.map(boardDTO, BoardVO.class);
        boardMapper.insert(boardVO);
    }

    @Override
    public List<BoardDTO> getAll() {
        log.info("getAll service");
        List<BoardDTO> dtoList = boardMapper.selectAll().stream()
                .map(vo -> modelMapper.map(vo, BoardDTO.class))
                .collect(Collectors.toList());

        return dtoList;
    }

    @Override
    public BoardDTO getOne(Long tno) {
        log.info("getOne service");
        BoardVO vo = boardMapper.selectOne(tno);
        BoardDTO dto = modelMapper.map(vo, BoardDTO.class);
        return dto;
    }

    @Override
    public void increaseViewCount(Long tno) {
        log.info("increaseViewCount service");
        boardMapper.updateViewCount(tno);
    }

    @Override
    public void modify(BoardDTO boardDTO) {
        log.info("modify service");
        BoardVO vo = modelMapper.map(boardDTO, BoardVO.class);
        boardMapper.update(vo);
    }

    @Override
    public void remove(Long tno) {
        log.info("remove service");
        boardMapper.delete(tno);
    }

//    @Override
//    public boolean checkPassphrase(Long tno, String passphrase) {
//        String dbPass = boardMapper.selectPassphrase(tno);
//        if (dbPass == null) return false;
//        return dbPass.equals(passphrase);
//    }
}
