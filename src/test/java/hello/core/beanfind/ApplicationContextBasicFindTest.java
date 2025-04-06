package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

// public 없어도 됨
 class ApplicationContextBasicFindTest {

     AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

     @Test
    @DisplayName("빈 이름으로 조회")
    void findBeanByName() {
         MemberService memberService = ac.getBean("memberService", MemberService.class);
         // 등록된 빈이 MemberServiceImpl의 인스턴스인지 확인하기
         Assertions.assertThat(memberService).isInstanceOf(MemberServiceImpl.class);
     }

}
