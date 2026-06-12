package com.kb.webapp_todo.todo.service;

import com.kb.webapp_todo.todo.dao.MemberDAO;
import com.kb.webapp_todo.todo.domain.MemberVO;
import com.kb.webapp_todo.todo.dto.MemberDTO;
import com.kb.webapp_todo.todo.util.MapperUtil;
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
