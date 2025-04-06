package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        //AppConfig appConfig = new AppConfig();
        // AppConfig클래스의 memberServie() 메서드를 통해 구현체 주입 받음.
        //MemberService memberService = appConfig.memberService();

        //MemberService memberService = new MemberServiceImpl();

        // AppConfig에서 @Bean으로 등록한 것들을 스프링 컨테이너에 넣어서 관리해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        // 이름, 타입(MemberService.class)알려주고 가져오기
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);


        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member " + memberA.getName());
        System.out.println("new member " + findMember.getName());
    }
}
