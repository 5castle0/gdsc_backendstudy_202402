package com.example.todo_api.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.BDDMockito;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
public class MemberServiceTest {
    @Mock
    private MemberRepository memberRepository;

    @InjectMocks
    private MemberService memberService;

    @Test
    public void createMemberTest_MemberExist() throws Exception{
        BDDMockito.given(memberRepository.findByRealId("anne")).willReturn(new Member());


        Assertions.assertThatThrownBy(()->{
            memberService.createMember("anne","1234");
        }).hasMessageContaining("이미 존재하는 ID입니다.")
                .isInstanceOf(Exception.class);
    }
}
