package com.geunskoo.core.order;

import com.geunskoo.core.discount.DiscountPolicy;
import com.geunskoo.core.discount.FixDiscountPolicy;
import com.geunskoo.core.domain.Member;
import com.geunskoo.core.domain.MemberRepository;
import com.geunskoo.core.domain.MemberService;
import com.geunskoo.core.domain.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {
    private MemberRepository memberRepository = new MemoryMemberRepository();
    private DiscountPolicy discountPolicy = new FixDiscountPolicy();

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
