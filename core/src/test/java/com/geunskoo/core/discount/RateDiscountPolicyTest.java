package com.geunskoo.core.discount;

import com.geunskoo.core.member.Grade;
import com.geunskoo.core.member.Member;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;


class RateDiscountPolicyTest {
    DiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP는 10%할인이 적용되어야 한다.")
    void vip_o(){
        //given
        Member member = new Member(1L, "userA", Grade.VIP);

        //when
        int discount = discountPolicy.discount(member, 25000);

        //then
        assertThat(discount).isEqualTo(2500);
    }
    @Test
    @DisplayName("BASIC은 10%할인이 적용이 안된다.")
    void vip_x(){
        //given
        Member member = new Member(1L, "userA", Grade.BASIC);

        //when
        int discount = discountPolicy.discount(member, 25000);

        //then
        assertThat(discount).isEqualTo(0);
    }

}