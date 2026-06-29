package com.kb.gallery.cart.dto;

import com.kb.gallery.cart.entity.Cart;
import lombok.Getter;

@Getter
public class CartRequest {
    private Integer itemId;

    // 장바구니 담기 요청 DTO를 엔티티 객체로 변환
    public Cart toEntity(Integer memberId) {
        return new Cart(memberId, itemId);
    }
}
