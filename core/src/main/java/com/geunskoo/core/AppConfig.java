package com.geunskoo.core;

import com.geunskoo.core.discount.DiscountPolicy;
import com.geunskoo.core.discount.FixDiscountPolicy;
import com.geunskoo.core.domain.MemberRepository;
import com.geunskoo.core.domain.MemberService;
import com.geunskoo.core.domain.MemberServiceImpl;
import com.geunskoo.core.domain.MemoryMemberRepository;
import com.geunskoo.core.order.OrderService;
import com.geunskoo.core.order.OrderServiceImpl;

import java.io.DataInput;

public class AppConfig {

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
