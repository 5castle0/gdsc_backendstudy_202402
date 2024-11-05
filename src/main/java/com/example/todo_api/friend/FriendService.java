package com.example.todo_api.friend;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import com.example.todo_api.todo.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FriendService {

    private final MemberRepository memberRepository;
    private final FriendRepository friendRepository;

    //친구 생성
    @Transactional
    public void createFriend(Member member1, Member member2) throws Exception{
        if(member1==null || member2==null){
            throw new Exception("존재하지 않는 멤버입니다.");
        }

        Friend friend = new Friend(member1,member2);
        friendRepository.save(friend);

    }

    @Transactional(readOnly = true)
    public List<Friend> getFriend(Member member) throws Exception{
        if(member==null){
            throw new Exception("존재하지 않는 멤버입니다.");
        }

        return friendRepository.findAllByMember(member);

    }
}
