package com.geunskoo.core.discount;

import com.geunskoo.core.domain.Grade;
import com.geunskoo.core.domain.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    private int discountPercent = 10; //10%할인

    @Override
    public int discount(Member member, int price) {
        if (member.getGrade() == Grade.VIP) {
            return price * discountPercent / 100;
        } else {
            return 0;
        }
    }
}
