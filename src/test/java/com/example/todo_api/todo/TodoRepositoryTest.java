package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import com.example.todo_api.member.MemberRepository;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.DEFINED_PORT) //실제 로컬환경에서 동작하는는 것처럼 test를 하겠다
public class TodoRepositoryTest {

    @Autowired
    private TodoRepository todoRepository;

    @Autowired
    private MemberRepository memberRepository;

    @Test
    @Transactional //transaction으로 설정
    @Rollback(false) //롤백을 안하게끔 설정
    void todoSaveTest(){
        //트랜잭션의 시작

        Todo todo = new Todo("todo content",false,null);
        todoRepository.save(todo);

        //트랜잭션의 종료 >> 커밋
        //error 발생시 자동으로 롤백

        //test 환경도 test이후 자동으로 롤백 => 수동으로 롤백을 꺼줘서 결과 확인

        Assertions.assertThat(todo.getId()).isNotNull();

    }

    @Test
    @Transactional
    void todoFindByIdTest(){
        //given //test코드 작성하는 방법
        Todo todo = new Todo("todo content",false,null);
        todoRepository.save(todo);

        todoRepository.flushAndClear();

        //when
        Todo findTodo = todoRepository.findById(todo.getId());

        //then
        Assertions.assertThat(findTodo.getId()).isEqualTo(todo.getId());
    }

    @Test
    @Transactional
    void todoFindAllTest(){
        Todo todo1 = new Todo("todo content1",false,null);
        Todo todo2 = new Todo("todo content2",false,null);
        Todo todo3 = new Todo("todo content3",false,null);

        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);

        List<Todo> todoList = todoRepository.findAll();

        Assertions.assertThat(todoList).hasSize(3);
//        System.out.println(todoList);

    }

    @Test
    @Transactional
    void todoFindAllByMemberTest(){
        Member member1 = new Member();
        Member member2 = new Member();

        memberRepository.save(member1);
        memberRepository.save(member2);

        Todo todo1 = new Todo("todo content1",false,member1);
        Todo todo2 = new Todo("todo content2",false,member1);
        Todo todo3 = new Todo("todo content3",false,member2);

        todoRepository.save(todo1);
        todoRepository.save(todo2);
        todoRepository.save(todo3);

        List<Todo> member1TodoList= todoRepository.findAllByMember(member1);
        List<Todo> member2TodoList= todoRepository.findAllByMember(member2);

        Assertions.assertThat(member1TodoList).hasSize(2);
        Assertions.assertThat(member2TodoList).hasSize(1);

    }

    @Test
    @Transactional
    @Rollback(false)
    void todoUpdateTest(){
        Todo todo1 = new Todo("todo content1",false,null);
        todoRepository.save(todo1);

        todoRepository.flushAndClear();

        Todo findTodo1 = todoRepository.findById(todo1.getId());
        findTodo1.updateContent("new content");
    }

    @Test
    @Transactional
    @Rollback(false)
    void todoDeleteTest(){
        Todo todo1 = new Todo("todo content1",false,null);
        Todo todo2 = new Todo("todo content2",false,null);
        todoRepository.save(todo1);
        todoRepository.save(todo2);

        todoRepository.flushAndClear();

        todoRepository.deleteById(todo1.getId());
    }

    //in memory database = 휘발성

    @AfterAll //모든 test가 끝났을 때 얘를 실행해라
    public static void doNotFinish(){
        System.out.println("test finished");
        while(true){}
    }



}
