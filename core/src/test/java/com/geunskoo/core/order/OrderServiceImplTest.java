package com.geunskoo.core.order;

import com.geunskoo.core.AppConfig;
import com.geunskoo.core.domain.Grade;
import com.geunskoo.core.domain.Member;
import com.geunskoo.core.domain.MemberService;
import com.geunskoo.core.domain.MemberServiceImpl;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class OrderServiceImplTest {

    @Test
    @DisplayName("주문 생성")
    void 주문생성(){
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();
        OrderService orderService = appConfig.orderService();
        Member memberA = new Member(1L, "userA", Grade.VIP);
        Member memberB = new Member(2L, "userA", Grade.BASIC);

        memberService.join(memberA);
        memberService.join(memberB);

        Order order1 = orderService.createOrder(1L, "itemA", 20000);
        Order order2 = orderService.createOrder(2L, "itemA", 20000);

        org.assertj.core.api.Assertions.assertThat(order1.getDiscountPrice()).isEqualTo(1000);
        org.assertj.core.api.Assertions.assertThat(order2.getDiscountPrice()).isEqualTo(0);

    }
}