package com.example.todo_api.friend;

import com.example.todo_api.member.Member;
import com.example.todo_api.todo.Todo;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class FriendRepository {
    @PersistenceContext
    private EntityManager em;

    //create
    public void save(Friend friend){
        em.persist(friend);
    }

    //read
    //단건 조회 ( 한 개의 데이터 조회)
    public Friend findById(Long friendId){
        return em.find(Friend.class,friendId);
    }

    //다건 조회(여러 개의 데이터 조회)
    public List<Friend> findAll(){
        return em.createQuery("select t from Friend as t",Friend.class).getResultList();
    }

    //delete
    public void deleteById(Long friendId){
        Friend friend = findById(friendId);
        em.remove(friendId);
    }

    public void flushAndClear(){
        em.flush();
        em.clear();
    }
}
