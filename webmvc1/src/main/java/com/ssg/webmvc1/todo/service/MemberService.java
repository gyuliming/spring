package com.ssg.webmvc1.todo.service;

import com.ssg.webmvc1.todo.dao.MemberDAO;
import com.ssg.webmvc1.todo.domain.MemberVO;
import com.ssg.webmvc1.todo.dto.MemberDTO;
import com.ssg.webmvc1.todo.util.MapperUtil;
import org.modelmapper.ModelMapper;

public enum MemberService {
    INSTANCE;

    private MemberDAO dao;
    private ModelMapper modelMapper;

    MemberService() {
        dao = new MemberDAO();
        modelMapper = MapperUtil.INSTANCE.get();
    }

    public MemberDTO login(String mid, String mpw) throws Exception {
        MemberVO vo = dao.getWithPassword(mid, mpw);
        MemberDTO dto = modelMapper.map(vo, MemberDTO.class);
        return dto;
    }
}
