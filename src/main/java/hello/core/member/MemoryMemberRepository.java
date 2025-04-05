package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository {

    // 제너릭 활용, 타입 지정된 Map.
    // Long을 키 타입으로 Member 타입 객체를 값으러 저장함. store.put(1L, new Member());

    // Map 은 인터페이스이기 때문에 구현체인 HashMap으로 생성함.
   private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        // 멤버의 아이디를 키로,멤버 객체를 값으로 저장함
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);

    }
}
