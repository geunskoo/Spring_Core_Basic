package com.geunskoo.core.autowired;

import com.geunskoo.core.AutoAppConfig;
import com.geunskoo.core.discount.DiscountPolicy;
import com.geunskoo.core.order.OrderService;
import com.geunskoo.core.order.OrderServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class AutoAppConfigTest {

    @Test
    @DisplayName("Autowired는 타입으로 조회한다..조회 빈이 2개 이상 문제 ? ")
    void autowiredDuplicateBean(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class);
        //DiscountPolicy => RateDiscountPolicy, FixDiscountPolicy 2개다 component스캔 대상이면 ?

        OrderServiceImpl orderService = ac.getBean(OrderServiceImpl.class);
        DiscountPolicy discountPolicy = ac.getBean(DiscountPolicy.class);
        Assertions.assertThat(orderService.getDiscountPolicy()).isSameAs(discountPolicy);

    }
}
