package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository {

    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;

    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); //Optional.ofNullable() 은 값이 Null인 경우에도 오류없이 반환하기 위함.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny(); //filter 조건에 일치하는 요소 1개를 Optional로 리턴한다. 조건에 일치하는 요소가 없으면 empty리턴.
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
}
