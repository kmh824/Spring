package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;


public class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    //test는 실행 순서가 정해지지 않음.
    //함수 하나씩 테스트가 끝날 때 마다 repository를 clear하기 위함.
    //test는 서로 의존관계가 없이 작성되어야 함. repository나 변수들의 중복 충돌을 방지하기 위함.
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get(); //optional으로 감싸진 반환값을 get()으로 꺼내옴.
        //System.out.println("result = " + (result == member)); //test에서 사용하기 불편함.
        //Assertions.assertEquals(member, result); //test에서 비교 후 같은지 다른지 확인하는  방법.
        assertThat(member).isEqualTo(result); //위의 방법보다 가독성이 좋고 쉬움.
                                              //Assertions에 커서를 두고 alt + Enter를 누른 뒤 static import를 설정하면 Assertions 생략 가능.
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();  //변수명 동시에 바꾸는 단축키 = shift + F6
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); //get()은 Member가 Optional이기 때문에 사용함.
        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2);

    }
}

