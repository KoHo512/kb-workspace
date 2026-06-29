package com.kb.gallery.cart.repository;

import com.kb.gallery.cart.entity.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface CartRepository extends JpaRepository<Cart, Integer> {

    // 장바구니 목록 조회 - 특정 회원의 장바구니 목록
    List<Cart> findAllByMemberId(Integer memberId);

    // 장바구니 정보 조회 - 특정 회원이 고른 특정 상품의 상세 정보
    Optional<Cart> findByMemberIdAndItemId(Integer memberId, Integer itemId);

    // 장바구니 삭제 - 특정 회원
    void deleteByMemberId(Integer memberId);

    // 장바구니 삭제 - 특정 회원의 특정 상품
    void deleteByMemberIdAndItemId(Integer memberId, Integer itemId);
}
