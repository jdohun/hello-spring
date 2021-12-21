package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemoryMemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Optional;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {
    MemberService memberService;
    MemoryMemberRepository memoryMemberRepository;

    @BeforeEach
    public void beforeEach(){
        memoryMemberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memoryMemberRepository);
    }

    @AfterEach  // 메소드가 끝날 때 마다 호출됨
    public void afterEach(){
        // Test는 순서 없이 작동되어야하며 같은 데이터가 들어간 경우를 생각해서
        // Test가 끝날떄마다 메모리를 초기화 시킨다.
        memoryMemberRepository.clearStore();
    }

    @Test
    void 회원가입() {   // Test 코드는 한글로 적어도 상관 없다.
        //given
        Member member  = new Member();
        member.setName("hello");

        //when
        Long SaveId = memberService.join(member);

        //then
        Member findMember = memberService.findOne(SaveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
    }

    @Test
    public void 중복_회원_예외(){
        //given
        Member member1 = new Member();
        member1.setName("spring");

        Member member2 = new Member();
        member2.setName("spring");

        //when
        memberService.join(member1);
        assertThrows(IllegalStateException.class, ()->memberService.join(member2));

        /*try{
            memberService.join(member2);
            fail();
        } catch (IllegalStateException e) {
            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
        }*/

        //then

    }

    @Test
    void findMembers() {
    }

    @Test
    void findOne() {
    }
}