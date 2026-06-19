package com.kb.springex.mapper;

import com.kb.springex.domain.TodoVO;

public interface TodoMapper {
    String getTime();

    void insert(TodoVO todoVO);
}
