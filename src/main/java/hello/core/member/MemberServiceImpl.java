package hello.core.member;

public class MemberServiceImpl implements MemberService {

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
