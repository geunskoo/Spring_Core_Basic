package com.geunskoo.core;

import com.geunskoo.core.discount.FixDiscountPolicy;
import com.geunskoo.core.domain.MemberRepository;
import com.geunskoo.core.domain.MemberService;
import com.geunskoo.core.domain.MemberServiceImpl;
import com.geunskoo.core.domain.MemoryMemberRepository;
import com.geunskoo.core.order.OrderService;
import com.geunskoo.core.order.OrderServiceImpl;

public class AppConfig {

    public OrderService orderService(){
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }

    public MemberService memberService(){
        return new MemberServiceImpl(new MemoryMemberRepository());
    }
}
