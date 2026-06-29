package com.kb.gallery.item.service;

import com.kb.gallery.item.dto.ItemRead;

import java.util.List;

public interface ItemService {
    // 전체 상품 목록 조회
    List<ItemRead> findAll();

    // 특정 id 리스트로 상품 목록 조회
    List<ItemRead> findAllById(List<Integer> ids);
}
