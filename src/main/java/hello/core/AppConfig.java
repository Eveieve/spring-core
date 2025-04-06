package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

public class AppConfig {
 // 1. new MemoryMemberRepository() 가 중복됨.

    private MemberRepository memberRepository() { // private 메소드 두기
        return new MemoryMemberRepository();
    }

    public MemberService memberService() {
        // 역할이 분명히 들어나게 됨.
        return new MemberServiceImpl(memberRepository()); // 생성자 주입함.
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy()); // 생성자 주입함.
    }

    public DiscountPolicy discountPolicy() {
        return new FixDiscountPolicy();
    }
}
