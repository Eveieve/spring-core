package hello.core.member;

public class MemberServiceImpl implements MemberService {

    // 실제 할당하는 부분 (new MemooryMemberRepository()) --> 구현체에 의존(구현체를 알고있음)
    // 추상화에도 의존(MemberRepository) 하고 구체화(MemoryMemberRepository)에도 의존하고 있음! ==> DIP 위반!!

    // 생성자 만든후, MemberServiceImpl는 추상화에만 의존하게 됨. (추상화에 의존한다는건 인터페이스/역할에만 의존한다는것)
    private final MemberRepository memberRepository;

    // 생성자 만들기 (생성자 주입을 위함)
    public MemberServiceImpl(MemberRepository memberRepository) { // AppConfig에서 memoryMemberRepository를 주입받아 memberRepository에 memoryMemberRepositoryrk gkfekdehla.
        this.memberRepository = memberRepository;
    }

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
