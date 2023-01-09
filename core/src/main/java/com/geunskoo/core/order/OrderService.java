package com.geunskoo.core.order;

public interface OrderService {

    //주문서 작성
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
