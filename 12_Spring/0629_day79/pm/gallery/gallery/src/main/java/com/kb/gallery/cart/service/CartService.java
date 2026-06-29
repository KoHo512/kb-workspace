package com.kb.gallery.cart.service;

import com.kb.gallery.cart.dto.CartRead;
import com.kb.gallery.cart.entity.Cart;

import java.util.List;

public interface CartService {

    // 장바구니 목록 조회 - 특정 회원의 장바구니 목록
    List<CartRead> findAll(Integer memberId);

    // 장바구니 정보 조회 - 특정 회원이 고른 특정 상품의 상세 정보
    CartRead find(Integer memberId, Integer itemId);

    // 장바구니 전체 삭제 - 특정 회원
    void removeAll(Integer memberId);

    // 장바구니 상품 삭제 - 특정 회원의 특정 상품
    void remove(Integer memberId, Integer itemId);

    // 장바구니 데이터 저장
    void save(Cart cart);
}
