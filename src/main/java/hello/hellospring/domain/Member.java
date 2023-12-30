package hello.hellospring.domain;

//회원 정보를 저장하는 Member객체
public class Member {

    private Long id;
    private String name;

    //회원 Id를 리턴받는 함수.
    public Long getId() {
        return id;
    }

    //회원 Id를 객체에 저장하는 함수.
    public void setId(Long id) {
        this.id = id;
    }

    //회원 이름을 리턴하는 함수.
    public String getName() {
        return name;
    }

    //회원 이름을 객체에 저장하는 함수.
    public void setName(String name) {
        this.name = name;
    }
}
