package com.example.todo_api.friend;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import com.example.todo_api.todo.Todo;
import com.example.todo_api.todo.TodoRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT)
public class FriendRepositoryTest {

    @Autowired
    private FriendRepository friendRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional
    @Rollback(false)
    void friendSaveTest(){

        Member member1 = new Member();
        Member member2 = new Member();

        memberRepository.save(member1);
        memberRepository.save(member2);

        //트랜잭션의 시작

        Friend friend = new Friend(member1,member2);
        friendRepository.save(friend);

        Assertions.assertThat(friend.getFriendId()).isNotNull();

    }

    @Test
    @Transactional
    void friendFindByIdTest(){

        Member member1 = new Member();
        Member member2 = new Member();

        memberRepository.save(member1);
        memberRepository.save(member2);

        //given
        Friend friend = new Friend(member1,member2);
        friendRepository.save(friend);

        friendRepository.flushAndClear();

        //when
        Friend findFriend = friendRepository.findById(friend.getFriendId());

        //then
        Assertions.assertThat(findFriend.getFriendId()).isEqualTo(friend.getFriendId());
    }


}
