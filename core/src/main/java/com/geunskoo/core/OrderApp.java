package com.geunskoo.core;

import com.geunskoo.core.domain.Grade;
import com.geunskoo.core.domain.Member;
import com.geunskoo.core.domain.MemberService;
import com.geunskoo.core.order.Order;
import com.geunskoo.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        OrderService orderService = ac.getBean("orderService", OrderService.class);

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Order order = orderService.createOrder(1L, "itemA", 20000);
        System.out.println("order = " + order);
    }
}
