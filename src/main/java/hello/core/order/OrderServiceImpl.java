package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;

public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository = new MemoryMemberRepository();
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy(); // 고정 할인 금액 정책 적용한 것

    // 새로운 할인 정책으로 변경하려면 우측 new RateDiscountPolicy()로 바꿔줘야 함. => 구현체 클래스에도 함께 의존하고 있음. => DIP 위반.
    // => 인터페이스에만 의존하도록 의존관계 변경해야함.

    // => 할인 정책을 변경하려면 클라이언트인 ORderServiceImpl코드를 고쳐야 함. => OCP 위반.
    private final DiscountPolicy discountPolicy = new RateDiscountPolicy();


    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);
        // 할인 관련한건 discountPolicy가 맡고 결과만 받기
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
