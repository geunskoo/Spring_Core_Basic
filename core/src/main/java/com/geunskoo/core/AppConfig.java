package com.geunskoo.core;

import com.geunskoo.core.discount.DiscountPolicy;
import com.geunskoo.core.discount.FixDiscountPolicy;
import com.geunskoo.core.domain.MemberRepository;
import com.geunskoo.core.domain.MemberService;
import com.geunskoo.core.domain.MemberServiceImpl;
import com.geunskoo.core.domain.MemoryMemberRepository;
import com.geunskoo.core.order.OrderService;
import com.geunskoo.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.DataInput;

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
