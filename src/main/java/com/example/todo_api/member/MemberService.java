package com.example.todo_api.member;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class MemberService {

    private final MemberRepository memberRepository;

    //멤버 생성
    @Transactional
    public void createMember(String memberId, String memberPw) throws Exception{
        Member member = memberRepository.findByRealId(memberId);

        if(member!=null){
            throw new Exception("이미 존재하는 ID입니다.");
        }

        member.setMemberId(memberId);
        member.setMemberPw(memberPw);

        memberRepository.save(member);

    }

    //read
    @Transactional(readOnly = true)
    public Member readMemeber(String memberId) throws Exception{
        Member member = memberRepository.findByRealId(memberId);

        if(member == null){
            throw new Exception("존재하지 않는 멤버입니다.");
        }

        return member;
    }

    //delete
    @Transactional
    public void deleteMember(String memberId, String memeberPw) throws Exception{
        Member member = memberRepository.findByRealId(memberId);

        if(member==null){
            throw new Exception("존재하지 않는 멤버입니다.");
        }

        if(member!=null && memberId==member.getMemberId() && memeberPw==member.getMemberPw()){
            Long id = member.getId();
            memberRepository.deleteById(id);
        }
    }
}
