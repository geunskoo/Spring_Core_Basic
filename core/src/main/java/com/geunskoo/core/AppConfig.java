package com.geunskoo.core;

import com.geunskoo.core.discount.DiscountPolicy;
import com.geunskoo.core.discount.FixDiscountPolicy;
import com.geunskoo.core.member.MemberRepository;
import com.geunskoo.core.member.MemberService;
import com.geunskoo.core.member.MemberServiceImpl;
import com.geunskoo.core.member.MemoryMemberRepository;
import com.geunskoo.core.order.OrderService;
import com.geunskoo.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    @Bean
    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {
        return new MemoryMemberRepository();
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
