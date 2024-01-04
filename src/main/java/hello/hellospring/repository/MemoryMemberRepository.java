package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.stereotype.Repository;

import java.util.*;

//구현체

public class MemoryMemberRepository implements MemberRepository {

    //회원 <Id, Name>을 담을 수 있는 HashMap store 생성.
    private static Map<Long, Member> store = new HashMap<>();
    //회원 Id 변수.
    private static long sequence = 0L;

    //Member객체의 Id를 setting해서 저장하고 리턴하는 함수.
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    //Id가 일치하는 Member객체를 리턴하는 함수.
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));
    }

    //Name이 일치하는 Member객체 리턴하는 함수.
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    //존재하는 모든 Member객체 리턴하는 함수.
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    //store를 clear하는 함수.
    public void clearStore() {
        store.clear();
    }
}