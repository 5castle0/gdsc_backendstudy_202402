package com.example.todo_api.friend;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
public class FriendServiceTest {

    @Mock
    private FriendRepository friendRepository;

    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private FriendService friendService;

//    @Test
//    public void createFriendTest() throws Exception{
//        Member member1 = new Member();
//        Member member2 = null;
//
//
//        given(memberRepository.findByRealId("anne")).willReturn(member1);
//
//
//        Assertions.assertThatThrownBy(()->{
//                    friendService.createFriend(member1,member2);
//                }).hasMessageContaining("존재하지 않는 멤버입니다.")
//                .isInstanceOf(Exception.class);
//
//    }
}
