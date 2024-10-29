package com.example.todo_api.member;

import com.example.todo_api.todo.Todo;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class MemberRepositoryTest {

    @Autowired
    MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    void todoDeleteTest(){
        Member member1 = new Member();
        Member member2 = new Member();

        memberRepository.save(member1);
        memberRepository.save(member2);

        memberRepository.flushAndClear();
        memberRepository.deleteById(member1.getId());
    }
}
