package com.kb.springex.mapper;

import org.apache.ibatis.annotations.Select;

// 데이터베이스의 현재 시각을 받아와서 문자열로 처리하는 Mapper 인터페이스 구성
public interface TimeMapper {
    @Select("SELECT now()")
    String getTime();
}
