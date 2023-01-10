package com.geunskoo.core;

import com.geunskoo.core.member.Grade;
import com.geunskoo.core.member.Member;
import com.geunskoo.core.member.MemberService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class memberApp {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        MemberService memberService = ac.getBean("memberService", MemberService.class);
        Member member = new Member(1L, "userA", Grade.VIP);

        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
