package com.geunskoo.core.discount;

import com.geunskoo.core.domain.Member;

public interface DiscountPolicy {
    /**
     * @return 할인 대상 금액
     */
    int discount(Member member, int price);
}
