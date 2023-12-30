package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    //Member객체의 Id를 setting해서 저장하고 리턴하는 함수.
    Member save(Member member);

    //Id가 일치하는 Member객체를 리턴하는 함수.
    Optional<Member> findById(Long id);

    //Name이 일치하는 Member객체 리턴하는 함수.
    Optional<Member> findByName(String name);

    //존재하는 모든 Member객체 리턴하는 함수.
    List<Member> findAll();
}
