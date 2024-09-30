package com.example.todo_api.bean;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Getter
@RequiredArgsConstructor //모든 final 필드에 대한 생성자를 자동으로 생성해주는 어노테이션
public class MyBean {
    //의존성 주입
     private final MySubBean mySubBean;
//    @Autowired
//    private MySubBean mySubBean;
//    @Autowired //통로라는 것을 표시해줌 //생성자가 하나이기에 생략 가능
//    public MyBean(MySubBean mySubBean){
//        this.mySubBean = mySubBean;
//    } //@RequiredArgsConstructor로 생략가능
}
