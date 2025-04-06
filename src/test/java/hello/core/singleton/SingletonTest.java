package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;

public class SingletonTest {

    @Test
    @DisplayName("스프링 없는 순수한 DI 컨테이너") // AppConfig는 요청이 올때마다 객체를 새로 생성
    void pureContainer() {
        AppConfig appConfig = new AppConfig();

        // 1. 조회: 호출할때마다 객체를 생성함
        MemberService memberService1 = appConfig.memberService();
        MemberService memberService2 = appConfig.memberService();

        // 참조값이 다른 것을 확인. 주소값이 다름 JVM 메모리에 올라갈때.
        // 웹 어플리케이션은 고객 요청이 많음. - 초당 오만개의 객체 생성되고 소멸됨 - 메모리 낭비가 심함
        System.out.println(memberService1 );
        System.out.println(memberService2 );

        Assertions.assertThat(memberService1).isNotSameAs(memberService2);

        // 해결 방안 - 객체가 딱 1개만 생성되고, 공유하도록 설계하기-> 싱글톤 패턴
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService instance = SingletonService.getInstance();
        SingletonService instance2 = SingletonService.getInstance();

        // 참조값이 같은 것 확인
        System.out.println(instance);
        System.out.println(instance2);

        Assertions.assertThat(instance).isSameAs(instance2);


    }
}
