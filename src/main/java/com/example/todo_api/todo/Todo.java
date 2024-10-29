package com.example.todo_api.todo;

import com.example.todo_api.member.Member;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED) //생성자 오류 고치기 위한 lombok
@Getter
public class Todo {

    @Id //pk라는 것을 알려주는 어노테이션
    @GeneratedValue(strategy = GenerationType.IDENTITY) //id가 생성될 때마다 자동 증가
    private Long id;

    @Column(name="todo_content", columnDefinition = "varchar(200)") //erd와 설계한 이름을 맞추기 위함
    private String content;

    @Column(name="todo_is_checked", columnDefinition = "tinyint(1)")
    private boolean isChecked;

    @JoinColumn(name="member_id") //fk임을 알림
    @ManyToOne(fetch = FetchType.LAZY)
    private Member member;

    //생성자를 만들기 위한 단축키 alt+insert
    //id는 자동으로 데이터베이스에서 만들기에 생성자 필요 x
    public Todo(String content, boolean isChecked, Member member) {
        this.content = content;
        this.isChecked = isChecked;
        this.member = member;
    }

    public void updateContent(String newContent){
        this.content = newContent;
    }
}
