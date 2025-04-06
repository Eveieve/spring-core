package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;

public class MemberApp {

    public static void main(String[] args) {

        AppConfig appConfig = new AppConfig();
        // AppConfig클래스의 memberServie() 메서드를 통해 구현체 주입 받음.
        MemberService memberService = appConfig.memberService();

        //MemberService memberService = new MemberServiceImpl();

        Member memberA = new Member(1L, "memberA", Grade.VIP);
        memberService.join(memberA);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member " + memberA.getName());
        System.out.println("new member " + findMember.getName());
    }
}
