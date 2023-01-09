package com.geunskoo.core.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MemberServiceImplTest {

    MemberService memberService = new MemberServiceImpl();

    @Test
    @DisplayName("회원 가입")
    void 회원가입() {
        //given
        Member member = new Member(1L, "userA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        assertThat(member).isEqualTo(findMember);
    }

}