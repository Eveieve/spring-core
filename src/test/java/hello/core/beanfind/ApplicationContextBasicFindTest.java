package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

// public 없어도 됨
 class ApplicationContextBasicFindTest {

     AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

     @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
         MemberService memberService = ac.getBean("memberService", MemberService.class);
         // 등록된 빈이 MemberServiceImpl의 인스턴스인지 확인하기
        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
     }

     @Test
    @DisplayName("타입으로 빈 조회")
    void findBeanByType() {
         MemberService memberService = ac.getBean(MemberService.class);
         assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
     }

     // 구현에 의존하는것은 안좋기 때문에 이런 테스트는 애초에 좋지 않음
     @Test
    @DisplayName("구체 타입으로 빈 조회")
    void findBeanByImplType() {
         MemberServiceImpl memberService = ac.getBean("memberService", MemberServiceImpl.class);
         assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

         System.out.println(memberService);
     }

     @Test
    @DisplayName("빈 이름으로 조회x")
    void findBeanByNameX() {
         MemberService xxxx = ac.getBean("xxxx", MemberService.class);
         // No Such DefinitionException: No bean named 'xxxx' available

         // throw 되어야 테스트 성공하는 것임.
         assertThrows(NoSuchBeanDefinitionException.class, () -> ac.getBean("xxxx", MemberService.class));
     }
}
