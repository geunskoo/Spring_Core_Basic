package com.geunskoo.core.singleton;

import com.geunskoo.core.AppConfig;
import com.geunskoo.core.member.MemberService;
import com.geunskoo.core.member.MemberServiceImpl;
import com.geunskoo.core.order.OrderService;
import com.geunskoo.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class ConfigurationSingletonTest {

    @Test
    @DisplayName("AppConfig의 컨테이너들의 싱글톤을 지키고 있을까?")
    void configurationTest() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
        OrderServiceImpl orderService = ac.getBean("orderService", OrderServiceImpl.class);

        System.out.println("memberService => memberRepository " + memberService.getMemberRepository());
        System.out.println("orderService => memberRepository " + orderService.getMemberRepository());

        assertThat(memberService.getMemberRepository()).isSameAs(memberService.getMemberRepository());
    }
}
