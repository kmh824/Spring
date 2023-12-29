package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); //Optional은 객체를 감싸는 래퍼 클래스로,
                                        //null을 반환할 수도 있는 메서드를 사용할 때 발생할 수 있는 NullPointerException을 방지하기 위해 사용됩니다.
    Optional<Member> findByName(String name);
    List<Member> findAll();
}
