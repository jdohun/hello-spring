package hello.hellospring.domain;

import javax.persistence.*;

@Entity
public class Member {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;    // 시스템상의 id
    //@Column(name = "username") 컬럼명이 상이할 경우
    private String name;

    // 실무에서 Getter and Setter에 대해 효용성에 대한 논지가 있으나
    // 현재 프로젝트에서는 간략화하여 진행하기 때문에 일단 사용
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
