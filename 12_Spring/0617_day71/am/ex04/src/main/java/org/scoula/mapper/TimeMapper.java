package org.scoula.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {
    @Select("SELECT sysdate() FROM dual")
    public String getTime();

    // MyBatisX 플러그인 설치
    public String getTime2();
}
