package com.example.todo_api.member;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;


@Repository
public class MemberRepository {
    @PersistenceContext
    private EntityManager em;

    //create
    public void save(Member member){
        em.persist(member);
    }

    //read
    //단건조회
    public Member findById(Long memberId){
        return em.find(Member.class,memberId);
    }

    //delete
    public void deleteById(Long memberId){
        Member member = findById(memberId);
        em.remove(member);
    }

    public void flushAndClear(){
        em.flush();
        em.clear();
    }

}

