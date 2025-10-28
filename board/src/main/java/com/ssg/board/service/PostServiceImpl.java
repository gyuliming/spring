package com.ssg.board.service;

import com.ssg.board.dao.PostDAO;
import com.ssg.board.dao.PostDAOImpl;
import com.ssg.board.domain.PostVO;
import com.ssg.board.dto.PostDTO;
import com.ssg.board.exception.PostException;
import com.ssg.board.util.MapperUtil;
import com.ssg.board.util.ValidationUtil;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.stream.Collectors;

public enum PostServiceImpl implements PostService {
    INSTANCE;

    private PostDAO dao;
    private ModelMapper modelMapper;
    private ValidationUtil validation = ValidationUtil.INSTANCE;

    PostServiceImpl() {
        this.dao = PostDAOImpl.INSTANCE;
        this.modelMapper = MapperUtil.INSTANCE.get();
    }

    @Override
    public List<PostDTO> getList() {
        List<PostVO> voList = dao.findAll();

        // VO List -> DTO List
        return voList.stream()
                .map(vo -> modelMapper.map(vo, PostDTO.class))
                .collect(Collectors.toList());
    }

    // 조회수 증가 포함
    @Override
    public PostDTO getDetail(long id) {
        PostVO vo = dao.findById(id)
                .orElseThrow(() -> new PostException("게시글이 존재하지 않습니다."));

        // VO -> DTO
        return modelMapper.map(vo, PostDTO.class);
    }

    // 검증 + 저장
    @Override
    public long write(PostDTO post) {
        // 입력값 검증
        validation.validatePost(post, true);

        // DTO -> VO
        PostVO vo = modelMapper.map(post, PostVO.class);

        // DAO 호출
        long newPostId = dao.save(vo);
        if (newPostId == 0) {
            throw new PostException("게시글 등록 실패");
        }
        return newPostId;
    }

    // 비번검증 + 수정
    @Override
    public void edit(PostDTO post, String passphrase) {
        // 비밀번호 검증
        if (!dao.checkPassphrase(post.getPostId(), passphrase)) {
            throw new PostException("비밀번호가 일치하지 않습니다.");
        }

        // 입력값 검증
        validation.validatePost(post, false);

        // DTO -> VO
        PostVO vo = modelMapper.map(post, PostVO.class);

        // DAO 호출
        boolean result = dao.update(vo);
        if (!result) {
            throw new PostException("게시글 수정 실패");
        }
    }

    // 비번검증 + 삭제
    @Override
    public void remove(long id, String passphrase) {
        // 비밀번호 검증
        if (!dao.checkPassphrase(id, passphrase)) {
            throw new PostException("비밀번호가 일치하지 않습니다.");
        }

        // DAO 호출
        boolean result = dao.delete(id);
        if (!result) {
            throw new PostException("게시글 삭제 실패");
        }
    }
}
