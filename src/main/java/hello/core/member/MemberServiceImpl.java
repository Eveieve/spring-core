package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 실제 할당하는 부분 (new MemooryMemberRepository()) --> 구현체에 의존(구현체를 알고있음)
    // 추상화에도 의존(MemberRepository) 하고 구체화(MemoryMemberRepository)에도 의존하고 있음! ==> DIP 위반!!
    private final MemberRepository memberRepository = new MemoryMemberRepository();

    @Override
    public void join(Member member) {
        // 저장소에 넘겨받은 회원을 저장
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        // 저장소에서 불러온 멤버를 리턴함.
       return memberRepository.findById(memberId);
    }
}
