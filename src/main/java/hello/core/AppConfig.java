package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AppConfig {
 // 1. new MemoryMemberRepository() 가 중복됨.

    @Bean  // bean 하면 스프링 컨테이너에 저장된다.
    public MemberRepository memberRepository() { // private 메소드 두기
        return new MemoryMemberRepository();
    }

    @Bean
    public MemberService memberService() {
        // 역할이 분명히 들어나게 됨.
        // 나중에 구현체를 변명하고 싶을때 이 코드만 변경하면 됨.
        return new MemberServiceImpl(memberRepository()); // 생성자 주입함.
    }

    @Bean
    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 생성자 주입함.
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        //return new FixDiscountPolicy();
        return new RateDiscountPolicy();// 이렇게만 변경하면 바꿔짐
    }
}
